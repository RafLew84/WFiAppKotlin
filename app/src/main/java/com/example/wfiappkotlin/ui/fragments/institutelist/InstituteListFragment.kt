package com.example.wfiappkotlin.ui.fragments.institutelist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wfiappkotlin.R
import com.example.wfiappkotlin.data.Institute
import com.example.wfiappkotlin.databinding.FragmentInstituteListBinding

class InstituteListFragment : Fragment() {

    private lateinit var binding: FragmentInstituteListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInstituteListBinding.inflate(inflater)

        val gridColumnCount = resources.getInteger(R.integer.grid_column_count)

        binding.recyclerView.apply {
            adapter = InstituteAdapter() {institute ->
                val action: NavDirections = InstituteListFragmentDirections.actionInstituteListFragmentToInstituteDetailFragment(
                    institute
                )
                findNavController().navigate(action)
            }
            //layoutManager = LinearLayoutManager(this@InstituteListFragment.requireContext())
            layoutManager = GridLayoutManager(this@InstituteListFragment.requireContext(), gridColumnCount)
        }

        return binding.root
    }
}