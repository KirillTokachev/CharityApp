package com.example.charityapp.presentation

import android.app.Application
import com.example.charityapp.di.DaggerApplicationComponent

class CharityApplication : Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}