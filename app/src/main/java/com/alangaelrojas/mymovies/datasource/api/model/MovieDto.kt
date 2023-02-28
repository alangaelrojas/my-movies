package com.alangaelrojas.mymovies.datasource.api.model

import com.google.gson.annotations.SerializedName

data class MovieDto(
    @SerializedName("id") val movieId: Int,
    @SerializedName("title") val movieTitle: String,
    @SerializedName("overview") val description: String,
    @SerializedName("poster_path") val movieCover: String,
    @SerializedName("popularity") val popularity: Double,
    @SerializedName("release_date") val releaseDate: String
)
