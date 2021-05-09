package com.android.ernb.moviesData.models

import com.android.ernb.popularmovies.api.model.Cast
import com.android.ernb.popularmovies.api.model.Review
import com.android.ernb.popularmovies.api.model.Video
/**
 * Created by Er Nadeem Bhat on 09/05/2021 ,11:11 AM
 * ernadeembhat@gmail.com
 * Copyright(R)
 */
data class MovieDetails(
    val trailers: List<Video>? = null,
    val reviews: List<Review>? = null,
    val casts: List<Cast>? = null
)