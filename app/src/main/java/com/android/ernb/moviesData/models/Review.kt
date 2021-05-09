package com.android.ernb.popularmovies.api.model

import com.google.gson.annotations.SerializedName
import java.util.*
/**
 * Created by Er Nadeem Bhat on 09/05/2021 ,11:12 AM
 * ernadeembhat@gmail.com
 * Copyright(R)
 */
data class Review(
    @SerializedName("id")
    val id:String=UUID.randomUUID().toString(),
    @SerializedName("author")
    val author: String? = null,
    @SerializedName("content")
    val content: String? = null,
    @SerializedName("url")
    val url:String?=null
)