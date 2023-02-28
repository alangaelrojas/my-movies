package com.alangaelrojas.mymovies.datasource.api.model

import com.google.gson.annotations.SerializedName

data class MoviesResponse<T>(
    @SerializedName("page") val page : Int,
    @SerializedName("results") val results : List<T>,
    @SerializedName("total_pages") val total_pages : Int,
    @SerializedName("total_results") val total_results : Int
)
