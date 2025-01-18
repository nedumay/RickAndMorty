package com.example.rickandmorty.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.ItemRickBinding

import com.example.rickandmorty.domain.model.InfoRick

class RecyclerViewAdapter : ListAdapter<InfoRick, RecyclerViewHolder>(RecyclerDiffCallback) {

    var onRickClickListener: ((InfoRick) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val binding = ItemRickBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val rick = getItem(position)
        with(holder.binding){
            with(rick){
                Glide.with(root.context).load(image).centerCrop().into(imageView)
                textViewName.text = name
                textViewGenderAndSpecies.text = "$species, $gender"
                textViewLocation.text = location.name
                textViewWatchLive.text = status
                when(status){
                    "Alive" -> {
                        textViewWatchLive.setTextColor(root.context.getColor(R.color.textAlive))
                        cardWatchLive.setCardBackgroundColor(root.context.getColor(R.color.backgroundAlive))
                    }
                    "Dead" -> {
                        textViewWatchLive.setTextColor(root.context.getColor(R.color.textDead))
                        cardWatchLive.setCardBackgroundColor(root.context.getColor(R.color.backgroundDead))
                    }
                    "unknown" -> {
                        textViewWatchLive.setTextColor(root.context.getColor(R.color.textUnknown))
                        cardWatchLive.setCardBackgroundColor(root.context.getColor(R.color.backgroundUnknown))
                    }
                }
                root.setOnClickListener {
                    onRickClickListener?.invoke(this)

                }

            }
        }
    }
}