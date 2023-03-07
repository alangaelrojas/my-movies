package com.alangaelrojas.mymovies.datasource.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies: List<MovieEntity>)

    @Query("SELECT * FROM Movies")
    suspend fun getMovies(): List<MovieEntity>

    @Query("SELECT * FROM Movies WHERE movieId = :movieId")
    suspend fun getMoviesById(movieId: Int): MovieEntity
}