package com.example.wfiappkotlin.ui.fragments.institutedetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wfiappkotlin.R
import com.example.wfiappkotlin.databinding.FragmentInstituteDetailBinding

class InstituteDetailFragment : Fragment() {

    private lateinit var binding: FragmentInstituteDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInstituteDetailBinding.inflate(inflater)
        return binding.root
    }
}