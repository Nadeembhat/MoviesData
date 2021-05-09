package com.android.ernb.popularmovies.api.responses.inner

import com.android.ernb.popularmovies.api.model.Review
import com.google.gson.annotations.SerializedName
/**
 * Created by Er Nadeem Bhat on 09/05/2021 ,10:50 AM
 * ernadeembhat@gmail.com
 * Copyright(R)
 */
class ReviewsResponse {
    @SerializedName("results")
    val reviews:List<Review>?=null
}