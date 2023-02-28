package com.alangaelrojas.mymovies.domain

import com.alangaelrojas.mymovies.datasource.api.RetrofitService
import com.alangaelrojas.mymovies.model.ItemMovie
import javax.inject.Inject

class MoviesRepository {

    @Inject
    lateinit var retrofitService: RetrofitService

    init {
        
    }

    fun getMovies(){



    }

}