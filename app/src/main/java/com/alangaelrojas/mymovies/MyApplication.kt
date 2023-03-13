package com.alangaelrojas.mymovies

import android.app.Application
import android.util.Log
import com.alangaelrojas.mymovies.sys.di.components.ContextComponent
import com.alangaelrojas.mymovies.sys.di.components.DaggerContextComponent
import com.alangaelrojas.mymovies.sys.di.modules.ContextModule

/*
* Application es la clase  que contiene el estado global de la aplicación. Ademas es el objeto principal que utiliza
* el sistema operativo para interactuar con la aplicación. Si este no se declara, Android utiliza una instancia por default.
* Esta entra en el metodo onCreate una vez la aplicacion es abierta, y se finaliza una vez esta es cerrada del cajon de aplicaciones
* o el garbage collector la cierra
* */
class MyApplication : Application() {


    override fun onCreate() {
        super.onCreate()

        contextComponent =
            DaggerContextComponent.builder().contextModule(ContextModule(applicationContext))
                .build()
    }

    companion object {

        @JvmStatic
        lateinit var contextComponent: ContextComponent
    }

}