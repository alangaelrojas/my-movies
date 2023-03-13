package com.alangaelrojas.mymovies.datasource.api

import com.alangaelrojas.mymovies.datasource.api.model.MovieDto
import com.alangaelrojas.mymovies.datasource.api.model.MoviesResponse
import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Interfaz usando el patron facade para llamar a los endpoint de la API
 * Podemos ver que son todas las llamadas a nuestro servidor o API y estas
 * pueden contener todas las anotaciones de las operaciones
 * HTTP
 * **/
interface RetrofitService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Response<MoviesResponse<MovieDto>>

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Response<MoviesResponse<MovieDto>>

    @GET("search/movie")
    suspend fun getMoviesBySearch(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("include_adult") includeAdult: Boolean
    ): Response<MoviesResponse<MovieDto>>
}