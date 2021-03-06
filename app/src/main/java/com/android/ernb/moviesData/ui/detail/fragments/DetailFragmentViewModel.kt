package com.android.ernb.moviesData.ui.detail.fragments

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.android.ernb.moviesData.models.MovieDetails
import com.android.ernb.moviesData.repository.MovieDetailRepository
import com.android.ernb.moviesData.util.Resource
import com.android.ernb.popularmovies.api.model.Movie
/**
 * Created by Er Nadeem Bhat on 09/05/2021 ,10:22 AM
 * ernadeembhat@gmail.com
 * Copyright(R)
 */
class DetailFragmentViewModel(app: Application, private val repository: MovieDetailRepository, val movie: Movie) : AndroidViewModel(app) {


    private val _movieDetails = MediatorLiveData<Resource<MovieDetails>>()
    val movieDetails: LiveData<Resource<MovieDetails>>
        get() = _movieDetails


    private var cancelRequest = false
    private var isPerformingQuery: Boolean = false

    fun getMovieDetailsall(){
        if (!isPerformingQuery) {
            isPerformingQuery = true
            executeRequest()
        }
    }
    private fun executeRequest() {
        val repositorySource = repository.getMovieDetail(movie.id)
        registerMediatorLiveData(repositorySource)
    }

    fun registerMediatorLiveData(repositorySource: LiveData<Resource<MovieDetails>>) {
        _movieDetails.addSource(repositorySource) { resourceMovieDetails ->
            if (!cancelRequest) {
                if (resourceMovieDetails != null) {
                    _movieDetails.value = resourceMovieDetails
                    if (resourceMovieDetails is Resource.Success || resourceMovieDetails is Resource.Error) {
                        //if response is reached error or success (no more loading)
                        unregisterMediatorLiveData(repositorySource)
                    }
                } else {
                    //if response is null
                    unregisterMediatorLiveData(repositorySource)
                }
            } else {
                //if request is canceled
                unregisterMediatorLiveData(repositorySource)
            }
        }
    }

    //unregister when whole response is null or when response ==Success or Error
    private fun unregisterMediatorLiveData(repositorySource:  LiveData<Resource<MovieDetails>>) {
        isPerformingQuery = false
        _movieDetails.removeSource(repositorySource)
    }


    fun cancelRequest() {
        cancelRequest = true
    }
}