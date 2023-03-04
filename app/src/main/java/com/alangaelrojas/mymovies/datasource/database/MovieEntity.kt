package com.alangaelrojas.mymovies.datasource.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Movies")
data class MovieEntity(
    @PrimaryKey(autoGenerate = false)
    val movieId: Int,
    @ColumnInfo("title") val movieTitle: String,
    @ColumnInfo("overview") val description: String,
    @ColumnInfo("posterPath") val movieCover: String,
    @ColumnInfo("popularity") val popularity: Double,
    @ColumnInfo("releaseDate") val releaseDate: String,
    @ColumnInfo("voteAverage") val voteAverage: String
)
