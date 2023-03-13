package com.alangaelrojas.mymovies.datasource.database

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * La anotación @Database Es una clase abstracta que extiende RoomDatabase.
 * Contiene una lista de objetos DAO y es responsable de crear y actualizar la base de datos.
 * Room utiliza anotaciones para especificar la versión de la base de datos y las tablas que se crean en ella.
 *
 * @see [https://developer.android.com/reference/kotlin/androidx/room/Database]
 * **/
@Database(entities = [MovieEntity::class], version = 1, exportSchema = true)
abstract class MoviesDatabase : RoomDatabase() {

    abstract fun moviesDao(): MoviesDao

}