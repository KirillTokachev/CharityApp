package com.example.charityapp.presentation.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.charityapp.presentation.views.SplashView

@InjectViewState
class SplashPresenter : MvpPresenter<SplashView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.downloading()
    }

    fun sleep(millis: Long) {
        Thread.sleep(millis)
    }
}