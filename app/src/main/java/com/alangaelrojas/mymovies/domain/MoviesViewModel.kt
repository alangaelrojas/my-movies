package com.alangaelrojas.mymovies.domain

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alangaelrojas.mymovies.model.ItemMovie

class MoviesViewModel : ViewModel() {


    lateinit var repository: MoviesRepository

    // LiveData que hara un puente entre la UI y el ViewModel
    val movieList by lazy { MutableLiveData<List<ItemMovie>>() }

    fun getMovies(){
        val movies = repository.getMovies()

    }

}