package com.android.ernb.popularmovies.api.responses


import com.android.ernb.popularmovies.api.responses.inner.CreditsResponse
import com.android.ernb.popularmovies.api.responses.inner.ReviewsResponse
import com.android.ernb.popularmovies.api.responses.inner.VideoResponse
import com.google.gson.annotations.SerializedName
/**
 * Created by Er Nadeem Bhat on 09/05/2021 ,11:08 AM
 * ernadeembhat@gmail.com
 * Copyright(R)
 */
//response for specific movie detail request
data class MovieDetailsResponse(
    @SerializedName("videos")
    val videoResponse: VideoResponse? = null,

    @SerializedName("reviews")
    val reviewResponse: ReviewsResponse? = null,

    @SerializedName("credits")
    val creditsResponse: CreditsResponse? = null
)