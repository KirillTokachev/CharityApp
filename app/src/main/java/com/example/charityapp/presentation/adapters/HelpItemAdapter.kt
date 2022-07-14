package com.example.charityapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.charityapp.R
import com.example.charityapp.databinding.HelpItemBinding
import com.example.charityapp.domain.model.HelpCategory
import com.example.charityapp.presentation.adapters.diffutils.HelpItemDiffCallback
import com.example.charityapp.presentation.adapters.viewholders.HelpItemViewHolder
import com.squareup.picasso.Picasso

class HelpItemAdapter() :
    ListAdapter<HelpCategory, HelpItemViewHolder>(HelpItemDiffCallback) {

    var onItemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HelpItemViewHolder {
        val binding = HelpItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HelpItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HelpItemViewHolder, position: Int) {
        val helpList = getItem(position)
        with(holder.binding) {
            with(helpList) {
                when (helpList.icon) {
                    CHILD -> {
                        Picasso.get().load(R.drawable.child)
                            .into(helpCategoryImage)
                    }
                    ADULTS -> {
                        Picasso.get().load(R.drawable.adults)
                            .into(helpCategoryImage)
                    }
                    ELDERLY -> {
                        Picasso.get().load(R.drawable.elderly)
                            .into(helpCategoryImage)
                    }
                    ANIMALS -> {
                        Picasso.get().load(R.drawable.animals)
                            .into(helpCategoryImage)
                    }
                    EVENTS -> {
                        Picasso.get().load(R.drawable.events)
                            .into(helpCategoryImage)
                    }
                }
                helpCategoryText.text = name
                root.setOnClickListener {
                    onItemClickListener?.onClick(this)
                }
            }
        }
    }

    interface OnItemClickListener {
        fun onClick(helpCategory: HelpCategory)
    }

    companion object {
        const val CHILD = "child.png"
        const val ADULTS = "adults.png"
        const val ELDERLY = "elderly.png"
        const val ANIMALS = "animals.png"
        const val EVENTS = "events.png"
    }
}