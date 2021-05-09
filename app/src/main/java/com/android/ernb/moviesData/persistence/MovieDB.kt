package com.android.ernb.moviesData.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.android.ernb.moviesData.persistence.dao.*
import com.android.ernb.popularmovies.api.model.Movie

/**
 * Created by Er Nadeem Bhat on 09/05/2021 ,12:02 PM
 * ernadeembhat@gmail.com
 * Copyright(R)
 */
@Database(
    entities = [Movie::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(Converter::class)
abstract class MovieDB : RoomDatabase() {
    abstract val movieDao: MovieAndDetailDao


}