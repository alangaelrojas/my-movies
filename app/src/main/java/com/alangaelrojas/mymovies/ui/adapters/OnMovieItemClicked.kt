package com.alangaelrojas.mymovies.ui.adapters

import com.alangaelrojas.mymovies.model.ItemMovie

interface OnMovieItemClick {
    fun onMovieItemClicked(movie: ItemMovie)
}