package com.alangaelrojas.mymovies.domain

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alangaelrojas.mymovies.model.ItemMovie

class MoviesViewModel : ViewModel() {

    val movieList by lazy { MutableLiveData<List<ItemMovie>>() }

    fun getMovies(){
        movieList.postValue(listOf<ItemMovie>(
            ItemMovie("Shark", "Pelicula de Steven Spielberg", ""),
            ItemMovie("Shinning", "Pelicula basada en el libro de Stephen King", ""),
            ItemMovie("Titanic", "Titanic", "")
        ))
    }

}