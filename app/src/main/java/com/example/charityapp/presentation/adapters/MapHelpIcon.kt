package com.example.charityapp.presentation.adapters

import com.example.charityapp.R

class MapHelpIcon {

    fun map(icon: String): Int {
        return when (icon) {
            CHILD -> {
                R.drawable.child
            }
            ADULTS -> {
                R.drawable.adults
            }
            ELDERLY -> {
                R.drawable.elderly
            }
            ANIMALS -> {
                R.drawable.animals
            }
            EVENTS -> {
                R.drawable.events
            }
            else -> {
                com.google.android.material.R.drawable.ic_mtrl_chip_checked_circle
            }
        }
    }

    companion object {
        const val CHILD = "child.png"
        const val ADULTS = "adults.png"
        const val ELDERLY = "elderly.png"
        const val ANIMALS = "animals.png"
        const val EVENTS = "events.png"
    }
}