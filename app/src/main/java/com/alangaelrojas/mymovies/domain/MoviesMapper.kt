package com.alangaelrojas.mymovies.domain

import com.alangaelrojas.mymovies.datasource.api.model.MovieDto
import com.alangaelrojas.mymovies.datasource.database.MovieEntity
import com.alangaelrojas.mymovies.model.ItemMovie

class MoviesMapper {

    fun mapMoviesDtoToMoviesEntity(moviesDto: List<MovieDto>): List<MovieEntity> {
        return moviesDto.map {
            MovieEntity(
                it.movieId,
                it.movieTitle,
                it.description,
                it.movieCover,
                it.popularity,
                it.releaseDate,
                it.voteAverage
            )
        }
    }

    fun mapMoviesEntityToItemMovies(moviesEntity: List<MovieEntity>): List<ItemMovie> {
        return moviesEntity.map {
            ItemMovie(
                it.movieId,
                it.movieTitle,
                it.description,
                it.movieCover,
                it.popularity,
                it.releaseDate,
                it.voteAverage
            )
        }
    }

    fun mapMoviesDtoToItemMovies(moviesDto: List<MovieDto>): List<ItemMovie> {
        return moviesDto.map {
            ItemMovie(
                it.movieId,
                it.movieTitle,
                it.description,
                it.movieCover,
                it.popularity,
                it.releaseDate,
                it.voteAverage
            )
        }
    }

}