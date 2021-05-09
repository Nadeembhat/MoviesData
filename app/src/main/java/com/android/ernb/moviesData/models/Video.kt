package com.android.ernb.popularmovies.api.model

import com.google.gson.annotations.SerializedName
import java.util.*


/**
 * Created by Er Nadeem Bhat on 09/05/2021 ,11:12 AM
 * ernadeembhat@gmail.com
 * Copyright(R)
 */
data class Video(
    @SerializedName("id")
    val id:String=UUID.randomUUID().toString(),
    @SerializedName("key")
    val key:String?=null,
    @SerializedName("name")
    val name:String?=null,
    @SerializedName("site")
    val site:String?=null
)