package com.example.wfiappkotlin.ui.fragments.institutelist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wfiappkotlin.data.DataProvider
import com.example.wfiappkotlin.data.Institute
import com.example.wfiappkotlin.databinding.RecyclerviewItemBinding

class InstituteAdapter(private val onItemClick: (Institute) -> Unit)
    : RecyclerView.Adapter<InstituteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InstituteViewHolder =
        InstituteViewHolder(RecyclerviewItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ), parent.context
        ) { onItemClick(DataProvider.institutes[it]) }

    override fun onBindViewHolder(holder: InstituteViewHolder, position: Int) {
        val currentInstitute = DataProvider.institutes[position]
        holder.bind(currentInstitute)
    }

    override fun getItemCount() = DataProvider.institutes.size
}