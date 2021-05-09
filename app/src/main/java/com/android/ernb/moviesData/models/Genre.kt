package com.android.ernb.popularmovies.api.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
/**
 * Created by Er Nadeem Bhat on 09/05/2021 ,11:10 AM
 * ernadeembhat@gmail.com
 * Copyright(R)
 */
@Parcelize
data class Genre(
    @SerializedName("name")
    val name:String
):Parcelable