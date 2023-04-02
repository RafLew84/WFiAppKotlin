package com.example.wfiappkotlin.ui.fragments.institutelist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wfiappkotlin.R
import com.example.wfiappkotlin.databinding.FragmentInstituteListBinding

class InstituteListFragment : Fragment() {

    private lateinit var binding: FragmentInstituteListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInstituteListBinding.inflate(inflater)
        return binding.root
    }
}