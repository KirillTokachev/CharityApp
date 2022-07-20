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

    private val mapper = MapHelpIcon()

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
                Picasso.get().load(mapper.map(helpList.icon))
                    .into(helpCategoryImage)
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
}