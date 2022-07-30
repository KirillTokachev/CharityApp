package com.example.charityapp.presentation.views

import com.arellomobile.mvp.MvpView

interface AuthorizationView : MvpView {

    fun validate()

    fun setupNavigateClickListener()
}