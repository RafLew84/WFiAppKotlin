package com.example.wfiappkotlin.ui.fragments.institutelist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.wfiappkotlin.R
import com.example.wfiappkotlin.data.DataProvider.institutes
import com.example.wfiappkotlin.databinding.FragmentInstituteListBinding
import java.util.*

class InstituteListFragment : Fragment() {

    private lateinit var binding: FragmentInstituteListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInstituteListBinding.inflate(inflater)

        val gridColumnCount = resources.getInteger(R.integer.grid_column_count)

        setupRecyclerView(binding.recyclerView, gridColumnCount)
        val (swipeDirs, dragDirs) = getDirs(gridColumnCount)
        attachItemTouchHelperToRecyclerView(dragDirs, swipeDirs, binding.recyclerView)

        return binding.root
    }

    private fun getDirs(gridColumnCount: Int): Pair<Int, Int> {
        val swipeDirs =
            if (gridColumnCount > 1) 0 else ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        val dragDirs = ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT or
                ItemTouchHelper.UP or ItemTouchHelper.DOWN
        return Pair(swipeDirs, dragDirs)
    }

    private fun setupRecyclerView(
        recyclerView: RecyclerView,
        gridColumnCount: Int
    ) {
        recyclerView.apply {
            adapter = InstituteAdapter() { institute ->
                val action: NavDirections =
                    InstituteListFragmentDirections.actionInstituteListFragmentToInstituteDetailFragment(
                        institute
                    )
                findNavController().navigate(action)
            }
            layoutManager =
                GridLayoutManager(this@InstituteListFragment.requireContext(), gridColumnCount)
        }
    }

    private fun attachItemTouchHelperToRecyclerView(
        dragDirs: Int,
        swipeDirs: Int,
        recyclerView: RecyclerView
    ) {
        ItemTouchHelper(
            object : ItemTouchHelper.SimpleCallback(dragDirs, swipeDirs) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    val from = viewHolder.adapterPosition
                    val to = target.adapterPosition
                    Collections.swap(institutes, from, to)
                    recyclerView.adapter?.notifyItemMoved(from, to)
                    return true
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    institutes.removeAt(viewHolder.adapterPosition)
                    recyclerView.adapter?.notifyItemRemoved(viewHolder.adapterPosition)
                }
            }).attachToRecyclerView(recyclerView)
    }
}