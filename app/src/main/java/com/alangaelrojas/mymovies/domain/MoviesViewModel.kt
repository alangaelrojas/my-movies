package com.alangaelrojas.mymovies.domain

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alangaelrojas.mymovies.model.ItemMovie
import kotlinx.coroutines.launch

class MoviesViewModel : ViewModel() {


    lateinit var repository: MoviesRepository

    init {
        repository = MoviesRepository()
    }

    // LiveData que hara un puente entre la UI y el ViewModel
    val movieList by lazy { MutableLiveData<List<ItemMovie>>() }
    val errorMovies by lazy { MutableLiveData<Unit>() }

    fun getMovies() {

        viewModelScope.launch {

            // esta en background
            val moviesResult = repository.getMovies()

            moviesResult.exception?.let {
                // si entra aca, es porque hubo un error
                errorMovies.value = Unit
            }

            moviesResult.entity?.let { movies ->
                // si entra aca, es porque se obtuvieron las peliculas
                movieList.value = movies
            }

        }

    }

}