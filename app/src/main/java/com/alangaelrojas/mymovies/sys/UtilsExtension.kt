package com.alangaelrojas.mymovies.sys

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(url: String, context: Context){
    val fullUrl = "https://image.tmdb.org/t/p/w500/$url"
    Glide.with(context).load(fullUrl).into(this)
}