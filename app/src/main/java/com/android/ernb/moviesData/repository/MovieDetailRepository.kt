package com.android.ernb.moviesData.repository

import androidx.lifecycle.LiveData
import com.android.ernb.moviesData.api.MoviesApi
import com.android.ernb.moviesData.api.responses.ApiEmptyResponse
import com.android.ernb.moviesData.api.responses.ApiErrorResponse
import com.android.ernb.moviesData.api.responses.ApiResponse
import com.android.ernb.moviesData.api.responses.ApiSuccessResponse
import com.android.ernb.moviesData.models.MovieDetails
import com.android.ernb.moviesData.util.NetworkBoundResourceNoCaching
import com.android.ernb.moviesData.util.Resource
import com.android.ernb.popularmovies.api.responses.MovieDetailsResponse

/**
 * Created by Er Nadeem Bhat on 09/05/2021 ,11:23 AM
 * ernadeembhat@gmail.com
 * Copyright(R)
 */
class MovieDetailRepository(
    private val movieApi: MoviesApi
) {

    fun getMovieDetail(movieId: Long): LiveData<Resource<MovieDetails>> {
        return object : NetworkBoundResourceNoCaching<MovieDetails, MovieDetailsResponse>() {
            override fun handleApiSuccessResponse(response: ApiSuccessResponse<MovieDetailsResponse>) {
                val detailsResponse= response.body
                val videos = detailsResponse.videoResponse?.videos
                val casts = detailsResponse.creditsResponse?.casts
                val reviews = detailsResponse.reviewResponse?.reviews
                result.value = Resource.Success(MovieDetails(videos,reviews,casts))
            }

            override fun handleApiEmptyResponse(response: ApiEmptyResponse<MovieDetailsResponse>) {
                //MovieDetails,has empty videos,casts,reviews
                result.value = Resource.Success(MovieDetails())
            }

            override fun handleApiErrorResponse(response: ApiErrorResponse<MovieDetailsResponse>) {
                result.value = Resource.Error(response.errorMessage,null)
            }

            override fun createCall(): LiveData<ApiResponse<MovieDetailsResponse>> =
                movieApi.getMovieDetail(movieId)

        }.asLiveData()
    }
}