package com.alangaelrojas.mymovies.model

/**
 * @param movieTitle Titulo de la pelicula
 * @param movieCover Caratula de la pelicula
 * @param description Descripcion de la pelicula
 * **/
data class ItemMovie(
    val movieTitle: String,
    val description: String,
    val movieCover: String
)
