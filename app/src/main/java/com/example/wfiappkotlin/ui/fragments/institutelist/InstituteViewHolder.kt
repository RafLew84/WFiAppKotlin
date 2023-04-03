package com.example.wfiappkotlin.ui.fragments.institutelist

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wfiappkotlin.data.Institute
import com.example.wfiappkotlin.databinding.RecyclerviewItemBinding

class InstituteViewHolder(
    private val binding: RecyclerviewItemBinding,
    private val context: Context,
    onItemClicked: (Int) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    init { itemView.setOnClickListener { onItemClicked(adapterPosition) } }

    fun bind(institute: Institute) {
        binding.apply {
            title.text = institute.title
            subTitle.text = institute.info
            Glide.with(context).load(institute.imageResource)
                .into(instituteImage)
        }
    }
}