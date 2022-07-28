package com.example.charityapp.presentation.views

import com.arellomobile.mvp.MvpView

interface HelpView : MvpView {

    fun fetchHelpCategory()

    fun loadHelpCategory()
}