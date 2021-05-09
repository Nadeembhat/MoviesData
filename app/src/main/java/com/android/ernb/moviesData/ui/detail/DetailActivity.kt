package com.android.ernb.moviesData.ui.detail

import PAGE_CAST
import PAGE_COUNT
import PAGE_INFO
import PAGE_REVIEW
import PAGE_VIDEOS
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.android.ernb.moviesData.R
import com.android.ernb.moviesData.databinding.ActivityDetailBinding
import com.android.ernb.moviesData.ui.detail.fragments.*
import com.android.ernb.popularmovies.api.model.Movie
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
/**
 * Created by Er Nadeem Bhat on 09/05/2021 ,10:21 AM
 * ernadeembhat@gmail.com
 * Copyright(R)
 */
private const val INTENT_EXTRA_MOVIE = "movie"

class DetailActivity : AppCompatActivity() {
    private val viewModel: DetailFragmentViewModel by viewModel {

        parametersOf(
            intent?.extras?.getParcelable(INTENT_EXTRA_MOVIE) ?: Movie()
        )
    }
    private lateinit var binding: ActivityDetailBinding
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_detail)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        initViewPager()
    }

    override fun onStart() {
        super.onStart()
        viewModel.getMovieDetailsall()
    }


    fun initViewPager() {
        viewPager = binding.contentDetail.viewpager
        tabLayout = binding.contentDetail.tabs
        viewPager.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int {
                return PAGE_COUNT
            }

            override fun createFragment(position: Int): Fragment {
                return when (position) {
                    PAGE_INFO -> GeneralDetailFragment()
                    PAGE_VIDEOS -> TrailersFragment()
                    PAGE_REVIEW -> ReviewsFragment()
                    PAGE_CAST -> CastFragment()
                    else -> throw IndexOutOfBoundsException()
                }
            }

        }
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = getTabTitle(position)
        }.attach()
    }

    private fun getTabTitle(position: Int): String? {
        return when (position) {
            PAGE_INFO -> "Info"
            PAGE_VIDEOS -> "Trailers"
            PAGE_REVIEW -> "Reviews"
            PAGE_CAST -> "Casts"
            else -> null
        }
    }


    companion object {
        private const val TAG = "DetailActivity"
        fun getIntent(movie:Movie, context: Context): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(INTENT_EXTRA_MOVIE, movie)
            return intent
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        viewModel.cancelRequest()
    }
}
