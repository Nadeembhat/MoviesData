package com.android.ernb.moviesData.ui.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.android.ernb.moviesData.R
import com.android.ernb.moviesData.api.MoviesApi
import com.android.ernb.moviesData.ui.detail.DetailActivity
import com.android.ernb.popularmovies.api.model.Movie
import org.koin.android.ext.android.inject
/**
 * Created by Er Nadeem Bhat on 09/05/2021 ,10:10 AM
 * ernadeembhat@gmail.com
 * Copyright(R)
 */
class MainActivity :AppCompatActivity(),
    MovieListFragment.Callbacks{
    val movieApi:MoviesApi by inject()
    private lateinit var toolbar:Toolbar
    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpToolbar()

        val isFragmentContainerEmpty = savedInstanceState == null
        if (isFragmentContainerEmpty) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.main_container,
                    MovieListFragment()
                )
                .commit()
        }
    }
    private fun setUpToolbar(){
        toolbar = findViewById(R.id.main_toolbar)
        setSupportActionBar(toolbar)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        (supportFragmentManager.findFragmentById(R.id.main_container) as MovieListFragment).onBackPressed()
    }

    override fun onMovieClick(movie: Movie) {
        val intent = DetailActivity.getIntent(movie,this)
        startActivity(intent)
    }

}
