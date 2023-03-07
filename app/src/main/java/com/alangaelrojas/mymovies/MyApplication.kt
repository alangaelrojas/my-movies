package com.alangaelrojas.mymovies

import android.app.Application
import com.alangaelrojas.mymovies.sys.di.components.ContextComponent
import com.alangaelrojas.mymovies.sys.di.components.DaggerContextComponent
import com.alangaelrojas.mymovies.sys.di.modules.ContextModule

class MyApplication : Application() {


    override fun onCreate() {
        super.onCreate()

        contextComponent = DaggerContextComponent.builder().contextModule(ContextModule(applicationContext)).build()
    }

    companion object {

        @JvmStatic
        lateinit var contextComponent: ContextComponent
    }

}