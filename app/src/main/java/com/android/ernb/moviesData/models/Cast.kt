package com.android.ernb.popularmovies.api.model

import com.google.gson.annotations.SerializedName
/**
 * Created by Er Nadeem Bhat on 09/05/2021 ,11:10 AM
 * ernadeembhat@gmail.com
 * Copyright(R)
 */
data class Cast(
    @SerializedName("cast_id")
    val castId:Int=0,

    @SerializedName("name")
    val name:String?=null,

    @SerializedName("profile_path")
    val profilePath:String?=null,

    @SerializedName("character")
    val character:String?=null

    )