package com.alangaelrojas.mymovies.sys.model

data class Result<T>(
    val entity: T?,
    val exception: Exception?
)
