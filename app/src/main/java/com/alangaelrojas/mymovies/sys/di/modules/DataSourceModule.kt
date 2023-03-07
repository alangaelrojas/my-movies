package com.alangaelrojas.mymovies.sys.di.modules

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.alangaelrojas.mymovies.datasource.api.RetrofitService
import com.alangaelrojas.mymovies.datasource.database.MoviesDao
import com.alangaelrojas.mymovies.datasource.database.MoviesDatabase
import com.alangaelrojas.mymovies.datasource.database.migrations.migrationNewColumn
import com.alangaelrojas.mymovies.sys.Constants
import com.alangaelrojas.mymovies.sys.Constants.SHARED_PREFERENCES_NAME
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module(includes = [ContextModule::class])
class DataSourceModule {

    @Provides
    fun providesGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    fun providesRetrofitInstance(gson: Gson): RetrofitService {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.theMovieDbBaseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        return retrofit.create(RetrofitService::class.java)
    }


    @Provides
    fun providesMoviesDatabase(context: Context): MoviesDatabase {
        return Room.databaseBuilder(context, MoviesDatabase::class.java, "movies.db")
            .addMigrations(migrationNewColumn)
            .build()
    }

    @Provides
    fun providesMoviesDao(database: MoviesDatabase): MoviesDao{
        return database.moviesDao()
    }

    @Provides
    fun providesSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
    }

}