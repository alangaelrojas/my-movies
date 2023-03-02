package com.alangaelrojas.mymovies.domain

import com.alangaelrojas.mymovies.datasource.api.RetrofitService
import com.alangaelrojas.mymovies.datasource.api.model.MovieDto
import com.alangaelrojas.mymovies.datasource.api.model.MoviesResponse
import com.alangaelrojas.mymovies.model.ItemMovie
import com.alangaelrojas.mymovies.sys.di.components.DaggerDataSourceComponent
import com.alangaelrojas.mymovies.sys.di.modules.DataSourceModule
import com.alangaelrojas.mymovies.sys.model.Result
import com.alangaelrojas.mymovies.sys.model.exceptions.NotFoundException
import javax.inject.Inject

class MoviesRepository {

    @Inject
    lateinit var retrofitService: RetrofitService

    init {
        DaggerDataSourceComponent.builder().dataSourceModule(DataSourceModule()).build().inject(this)
    }

    suspend fun getMovies(): Result<List<ItemMovie>> {

        val moviesResponse = retrofitService.getPopularMovies("", "", 0)

        val httpCode = moviesResponse.code()

        if (httpCode in  300..599){
            return Result(null, NotFoundException())
        }

        // el body es el cuerpo de la respuesta http que viene del servidor
        val body: MoviesResponse<MovieDto>? = moviesResponse.body()

        if (body == null){
            return Result(null, NotFoundException())
        }

        // Aqui hacemos un mapeo de List<MovieDto> para convertirlo a List<ItemMovie>
        val listMovies: List<ItemMovie> = body.results.map { movieDto ->
                ItemMovie(
                    movieId = movieDto.movieId,
                    movieTitle = movieDto.movieTitle,
                    description = movieDto.description,
                    movieCover = movieDto.movieCover,
                    popularity = movieDto.popularity,
                    releaseDate = movieDto.releaseDate
                )
            }

        return Result(listMovies, null)
    }

}