package com.alangaelrojas.mymovies.datasource.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * Es una interfaz que define operaciones de acceso a datos que se pueden realizar en la base de datos.
 * Las anotaciones se utilizan en los métodos de la interfaz para definir las consultas SQL que se ejecutan en la base de datos.
 * “Room utiliza el patrón de repositorio para proporcionar una capa de abstracción sobre los DAO.”
 *
 * @see [#href https://developer.android.com/training/data-storage/room/accessing-data?hl=es-419]
 * **/
@Dao
interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies: List<MovieEntity>)

    @Query("SELECT * FROM Movies")
    suspend fun getMovies(): List<MovieEntity>

    @Query("SELECT * FROM Movies WHERE movieId = :movieId")
    suspend fun getMoviesById(movieId: Int): MovieEntity

    @Query("UPDATE Movies SET overview = :description WHERE movieId = :movieId")
    suspend fun updateDescriptionById(description: String, movieId: Int)
}