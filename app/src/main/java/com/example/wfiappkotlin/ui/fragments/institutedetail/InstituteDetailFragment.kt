package com.example.wfiappkotlin.ui.fragments.institutedetail

import android.os.Build
import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.wfiappkotlin.data.Institute
import com.example.wfiappkotlin.databinding.FragmentInstituteDetailBinding
import com.example.wfiappkotlin.util.parcelable

class InstituteDetailFragment : Fragment() {

    private lateinit var binding: FragmentInstituteDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInstituteDetailBinding.inflate(inflater)

        setupUi(getCurrentInstitute())

        return binding.root
    }

    private fun getCurrentInstitute() = if (SDK_INT >= Build.VERSION_CODES.TIRAMISU)
        arguments?.getParcelable("institute", Institute::class.java)
    else
        arguments?.parcelable("institute")

    private fun setupUi(currentInstitute: Institute?) {
        Glide.with(this)
            .load(currentInstitute?.imageResource)
            .into(binding.instituteImageDetail)

        binding.titleDetail.text = currentInstitute?.title
    }
}