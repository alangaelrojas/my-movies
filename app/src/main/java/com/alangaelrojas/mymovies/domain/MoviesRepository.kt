package com.alangaelrojas.mymovies.domain

import android.content.SharedPreferences
import com.alangaelrojas.mymovies.MyApplication
import com.alangaelrojas.mymovies.datasource.api.RetrofitService
import com.alangaelrojas.mymovies.datasource.api.model.MovieDto
import com.alangaelrojas.mymovies.datasource.api.model.MoviesResponse
import com.alangaelrojas.mymovies.datasource.database.MovieEntity
import com.alangaelrojas.mymovies.datasource.database.MoviesDao
import com.alangaelrojas.mymovies.model.ItemMovie
import com.alangaelrojas.mymovies.sys.di.components.DaggerDataSourceComponent
import com.alangaelrojas.mymovies.sys.di.modules.ContextModule
import com.alangaelrojas.mymovies.sys.di.modules.DataSourceModule
import com.alangaelrojas.mymovies.sys.model.Result
import com.alangaelrojas.mymovies.sys.model.exceptions.NotFoundException
import javax.inject.Inject

class MoviesRepository {

    @Inject
    lateinit var retrofitService: RetrofitService

    @Inject
    lateinit var moviesDao: MoviesDao

    @Inject
    lateinit var preferences: SharedPreferences

    private val mapper = MoviesMapper()

    init {
        val context = MyApplication.contextComponent.context()
        DaggerDataSourceComponent.builder().contextModule(ContextModule(context))
            .dataSourceModule(DataSourceModule()).build().inject(this)
    }

    suspend fun getMovies(): Result<List<ItemMovie>> {

        if (connectedToInternet()) {
            // Obtiene movies del servidor
            val remoteMovies = getRemoteMovies() ?: return Result(null, NotFoundException())

            // Aqui mapeo las movies del servidor a movies en la base de datos local
            val entities: List<MovieEntity> = mapper.mapMoviesDtoToMoviesEntity(remoteMovies)
            saveMovies(entities)

            val movies: List<ItemMovie> = mapper.mapMoviesDtoToItemMovies(remoteMovies)

            return Result(movies, null)
        }

        val localMovies: List<MovieEntity> = getLocalMovies()

        val movies: List<ItemMovie> = mapper.mapMoviesEntityToItemMovies(localMovies)
        return Result(movies, null)
    }

    private suspend fun saveMovies(movieEntities: List<MovieEntity>) {
        moviesDao.insertMovies(movieEntities)
    }

    private suspend fun getLocalMovies(): List<MovieEntity> {
        return moviesDao.getMovies()
    }

    private suspend fun getRemoteMovies(): List<MovieDto>? {
        val moviesResponse =
            retrofitService.getPopularMovies("YOUR API KEY", language, 1)

        val httpCode = moviesResponse.code()

        if (httpCode in 300..599) {
            return null
        }

        // el body es el cuerpo de la respuesta http que viene del servidor
        val body: MoviesResponse<MovieDto> = moviesResponse.body() ?: return null

        return body.results
    }

    private val language: String = preferences.getString("language", "") ?: ""

    private fun connectedToInternet(): Boolean = true


}