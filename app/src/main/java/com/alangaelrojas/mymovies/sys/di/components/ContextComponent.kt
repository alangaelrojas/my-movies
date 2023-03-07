package com.alangaelrojas.mymovies.sys.di.components

import android.content.Context
import com.alangaelrojas.mymovies.sys.di.modules.ContextModule
import dagger.Component

@Component(modules = [ContextModule::class])
interface ContextComponent {

    fun context(): Context
}