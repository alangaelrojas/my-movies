package com.alangaelrojas.mymovies.domain

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.alangaelrojas.mymovies.datasource.api.model.MovieDto
import com.alangaelrojas.mymovies.datasource.database.MovieEntity
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

class MoviesMapperTest {

    private lateinit var mapper: MoviesMapper

    @Before
    fun setUp() {
        // Antes de ejecutarse las pruebas
        mapper = MoviesMapper()
    }

    @After
    fun tearDown() {
        // Despues de que se ejecutan las pruebas

    }

    @Test
    fun mapMoviesDtoToMoviesEntity_passWhenMovieIdMatch() {

        val dtos = listOf(
            MovieDto(1, "Titanic", "Hundimiento de un barco","", 1.0, "", "")
        )

        val entities = listOf(
            MovieEntity(1, "Titanic", "Hundimiento de un barco","", 1.0, "", "")
        )

        val result = mapper.mapMoviesDtoToMoviesEntity(dtos)

        assertEquals(entities[0].movieId, result[0].movieId)
    }

    @Test
    fun mapMoviesDtoToMoviesEntity_passWhenMovieIdDoesNotMatch() {

        val dtos = listOf(
            MovieDto(1, "Titanic", "Hundimiento de un barco","", 1.0, "", "")
        )

        val entities = listOf(
            MovieEntity(2, "Titanic", "Hundimiento de un barco","", 1.0, "", "")
        )

        val result = mapper.mapMoviesDtoToMoviesEntity(dtos)

        assertNotEquals(entities[0].movieId, result[0].movieId)
    }

    @Test
    fun mapMoviesDtoToMoviesEntity_passWithListSizeAreSame() {

        val dtos = listOf(
            MovieDto(1, "Titanic", "Hundimiento de un barco","", 1.0, "", "")
        )

        val entities = listOf(
            MovieEntity(1, "Titanic", "Hundimiento de un barco","", 1.0, "", "")
        )

        val result = mapper.mapMoviesDtoToMoviesEntity(dtos)

        assert(result.size == entities.size)
    }

    @Test
    fun mapMoviesDtoToMoviesEntity_passWithListSizeAreDifferent() {

        val dtos = listOf(
            MovieDto(1, "Titanic", "Hundimiento de un barco","", 1.0, "", "")
        )

        val entities = listOf(
            MovieEntity(1, "Titanic", "Hundimiento de un barco","", 1.0, "", "")
        )

        val result = mapper.mapMoviesDtoToMoviesEntity(dtos)

        assertFalse(result.size != entities.size)
    }

}