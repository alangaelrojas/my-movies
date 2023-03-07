package com.alangaelrojas.mymovies.sys.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ContextModule(
    private val context: Context
) {

    // Con Provides definimos que el context sea inyectable a travez de la app
    @Provides
    fun providesContext(): Context {
        return context
    }

}