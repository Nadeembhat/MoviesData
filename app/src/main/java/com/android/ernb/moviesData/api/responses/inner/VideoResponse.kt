package com.android.ernb.popularmovies.api.responses.inner

import com.android.ernb.popularmovies.api.model.Video
import com.google.gson.annotations.SerializedName
/**
 * Created by Er Nadeem Bhat on 09/05/2021 ,10:48 AM
 * ernadeembhat@gmail.com
 * Copyright(R)
 */
class VideoResponse {
    @SerializedName("results")
    val videos:List<Video>?=null
}