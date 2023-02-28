package com.alangaelrojas.mymovies.sys.di.components

import com.alangaelrojas.mymovies.domain.MoviesRepository
import com.alangaelrojas.mymovies.sys.di.modules.DataSourceModule
import dagger.Component

@Component(modules = [DataSourceModule::class])
interface DataSourceComponent {
    fun inject(moviesRepository: MoviesRepository)
}