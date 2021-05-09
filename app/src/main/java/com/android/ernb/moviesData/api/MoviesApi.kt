package com.android.ernb.moviesData.api

import androidx.lifecycle.LiveData
import com.android.ernb.moviesData.BuildConfig
import com.android.ernb.moviesData.api.responses.ApiResponse
import com.android.ernb.popularmovies.api.responses.MovieDetailsResponse
import com.android.ernb.popularmovies.api.responses.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
/**
 * Created by Er Nadeem Bhat on 09/05/2021 ,11:43 AM
 * ernadeembhat@gmail.com
 * Copyright(R)
 */
interface MoviesApi {

    @GET("movie/popular")
    fun getPopularMovies(
        @Query("page") page: Int = 1,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): LiveData<ApiResponse<MoviesResponse>>

    @GET("movie/top_rated")
    fun getTopRatedMovies(
        @Query("page") page: Int = 1,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): LiveData<ApiResponse<MoviesResponse>>

    @GET("movie/upcoming")
    fun geUpcomingMovies(
        @Query("page") page: Int = 1,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): LiveData<ApiResponse<MoviesResponse>>

    @GET("search/movie")
    fun searchMovies(
        @Query("query") query: String? = null,
        @Query("page") page: Int = 1,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): LiveData<ApiResponse<MoviesResponse>>

    @GET("movie/{id}")
    fun getMovieDetail(
        @Path("id") id: Long,
        @Query("append_to_response") details: String = "videos,credits,reviews",
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): LiveData<ApiResponse<MovieDetailsResponse>>

}