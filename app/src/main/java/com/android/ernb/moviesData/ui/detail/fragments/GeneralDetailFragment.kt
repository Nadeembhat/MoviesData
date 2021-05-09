package com.android.ernb.moviesData.ui.detail.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.ernb.moviesData.databinding.FragmentGeneralDetailBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
/**
 * Created by Er Nadeem Bhat on 09/05/2021 ,10:21 AM
 * ernadeembhat@gmail.com
 * Copyright(R)
 */
/**
 * A simple [Fragment] subclass.
 */
class GeneralDetailFragment : Fragment() {

    private lateinit var binding: FragmentGeneralDetailBinding
    private val viewModel: DetailFragmentViewModel by sharedViewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGeneralDetailBinding.inflate(inflater,container,false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }
}
