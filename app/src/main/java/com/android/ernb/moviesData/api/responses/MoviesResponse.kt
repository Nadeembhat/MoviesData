package com.android.ernb.popularmovies.api.responses

import com.android.ernb.popularmovies.api.model.Movie
import com.google.gson.annotations.SerializedName
/**
 * Created by Er Nadeem Bhat on 09/05/2021 ,10:51 AM
 * ernadeembhat@gmail.com
 * Copyright(R)
 */
//response for search,popular,top-rated & upcoming requests
class MoviesResponse{

    @SerializedName("page")
    var page:Int=1

    @SerializedName("total_results")
    val totalResults:Int=0

    @SerializedName("total_pages")
    val total_pages:Int=0

    @SerializedName("results")
    val movies:List<Movie>?=null
}