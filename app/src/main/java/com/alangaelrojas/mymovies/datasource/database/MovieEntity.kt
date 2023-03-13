package com.alangaelrojas.mymovies.datasource.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

/**
 * Los POJOs o Data Classes con la anotacion @Entity le dicen a Room que esta sera una entidad o tabla
 * de SQL, donde cada propiedad de este objeto pueden llevar la anotacion @ColmnInfo, @PrimaryKey, @Ignore, estas anotaciones
 * definen las caracteristicas de las propiedades dentro de la tabla de SQL.
 *
 * @link [https://developer.android.com/training/data-storage/room/defining-data?hl=es-419]
 * **/
@Entity(tableName = "Movies")
data class MovieEntity(
    @Ignore
    @PrimaryKey(autoGenerate = false)
    val movieId: Int,
    @ColumnInfo("title") val movieTitle: String,
    @ColumnInfo("overview") val description: String,
    @ColumnInfo("posterPath") val movieCover: String,
    @ColumnInfo("popularity") val popularity: Double,
    @ColumnInfo("releaseDate") val releaseDate: String,
    @ColumnInfo("voteAverage") val voteAverage: String
)
