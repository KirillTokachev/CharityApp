package com.example.charityapp.presentation.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.charityapp.presentation.views.SplashView

@InjectViewState
class SplashPresenter : MvpPresenter<SplashView>() {

    fun sleep(millis: Long) {
        Thread.sleep(millis)
    }

    override fun attachView(view: SplashView?) {
        super.attachView(view)
        viewState.downloading()
    }
}