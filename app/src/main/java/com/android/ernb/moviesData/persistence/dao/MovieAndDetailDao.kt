package com.android.ernb.moviesData.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.android.ernb.moviesData.util.Category
import com.android.ernb.popularmovies.api.model.Movie
/**
 * Created by Er Nadeem Bhat on 09/05/2021 ,12:08 PM
 * ernadeembhat@gmail.com
 * Copyright(R)
 */
@Dao
interface MovieAndDetailDao{

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertMovies(vararg movie: Movie):LongArray

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie: Movie)

    @Update
    fun updateMovie(movie:Movie)

    @Query("SELECT * FROM movie WHERE category=:category LIMIT (:pageNumber*20)")
    fun getMovies(pageNumber: Int,category: Category):LiveData<List<Movie>>

    /*LIST VIEW STATE*/
    @Query("SELECT * FROM movie WHERE title LIKE '%' || :query || '%'  LIMIT (:pageNumber*20) ")
    fun searchListMovie(query: String,pageNumber:Int):LiveData<List<Movie>>



}