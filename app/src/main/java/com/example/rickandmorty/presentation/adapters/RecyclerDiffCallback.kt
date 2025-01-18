package com.example.rickandmorty.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.rickandmorty.domain.model.InfoRick

object RecyclerDiffCallback : DiffUtil.ItemCallback<InfoRick>() {
    override fun areItemsTheSame(oldItem: InfoRick, newItem: InfoRick): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: InfoRick, newItem: InfoRick): Boolean {
        return oldItem == newItem
    }
}