package com.alangaelrojas.mymovies.sys

import android.content.Context
import android.widget.ImageView
import com.alangaelrojas.mymovies.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

fun ImageView.loadImage(url: String, context: Context){
    val fullUrl = "https://image.tmdb.org/t/p/w500/$url"

    val options = RequestOptions()
        .diskCacheStrategy(DiskCacheStrategy.NONE)
        .error(R.drawable.cover_movie)

    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(fullUrl)
        .into(this)
}