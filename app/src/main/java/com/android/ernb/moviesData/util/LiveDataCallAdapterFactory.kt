package com.android.ernb.popularmovies.util

import androidx.lifecycle.LiveData
import com.android.ernb.moviesData.api.responses.ApiResponse
import retrofit2.CallAdapter
import retrofit2.CallAdapter.Factory
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
/**
 * Created by Er Nadeem Bhat on 09/05/2021 ,10:29 AM
 * ernadeembhat@gmail.com
 * Copyright(R)
 */
class LiveDataCallAdapterFactory : Factory() {
    override fun get(
        returnType: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
        if (Factory.getRawType(returnType) != LiveData::class.java) {
            return null
        }
        val observableType = Factory.getParameterUpperBound(0, returnType as ParameterizedType)
        val rawObservableType = Factory.getRawType(observableType)
        if (rawObservableType != ApiResponse::class.java) {
            throw IllegalArgumentException("type must be a resource")
        }
        if (observableType !is ParameterizedType) {
            throw IllegalArgumentException("resource must be parameterized")
        }
        val bodyType = Factory.getParameterUpperBound(0, observableType)
        return LiveDataCallAdapter<Any>(bodyType)
    }
}