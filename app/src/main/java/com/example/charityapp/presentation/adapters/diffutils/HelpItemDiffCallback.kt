package com.example.charityapp.presentation.adapters.diffutils

import androidx.recyclerview.widget.DiffUtil
import com.example.charityapp.domain.model.HelpCategory

object HelpItemDiffCallback : DiffUtil.ItemCallback<HelpCategory>() {

    override fun areItemsTheSame(oldItem: HelpCategory, newItem: HelpCategory): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: HelpCategory, newItem: HelpCategory): Boolean {
        return oldItem == newItem
    }
}