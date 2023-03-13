package com.alangaelrojas.mymovies.database

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.alangaelrojas.mymovies.datasource.database.MovieEntity
import com.alangaelrojas.mymovies.datasource.database.MoviesDao
import com.alangaelrojas.mymovies.datasource.database.MoviesDatabase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * JUnit es un marco de pruebas unitarias para el lenguaje de programación Java
 * que se utiliza ampliamente en el desarrollo de aplicaciones de Android.
 * JUnit permite a los desarrolladores escribir y ejecutar pruebas unitarias
 * para sus aplicaciones de forma automatizada.
 *
 *
 * @see [https://developer.android.com/training/testing/local-tests]
 *
 * **/
@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class DatabaseMoviesDaoTest {

    private lateinit var database: MoviesDatabase
    private lateinit var moviesDao: MoviesDao

    @Before
    fun setup() {

        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            MoviesDatabase::class.java
        ).build()

        moviesDao = database.moviesDao()
    }

    @Test
    fun insertMovie_shouldPassWithMovieId() =
        runBlocking {

            val movies = listOf(
                MovieEntity(1, "Titanic", "Hundimiento de un barco", "", 1.0, "", ""),
                MovieEntity(2, "Black adam", "Pelicula de DC", "", 2.0, "", "")
            )

            moviesDao.insertMovies(movies)

            val moviesFromDb = moviesDao.getMovies()

            Assert.assertEquals(movies[0].movieId, moviesFromDb[0].movieId)

        }

    @Test
    fun insertMovie_shouldPassWithDescriptionUpdated() =
        runBlocking {

            val movies = listOf(
                MovieEntity(1, "Titanic", "Hundimiento de un barco", "", 1.0, "", ""),
                MovieEntity(2, "Black adam", "Pelicula de DC", "", 2.0, "", "")
            )

            moviesDao.insertMovies(movies)

            moviesDao.updateDescriptionById("Hundimiento", 1)

            val moviesFromDb = moviesDao.getMovies()

            Assert.assertNotEquals(movies[0].description, moviesFromDb[0].description)

        }
}