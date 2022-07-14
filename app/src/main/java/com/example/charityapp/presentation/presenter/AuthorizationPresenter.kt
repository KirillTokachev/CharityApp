package com.example.charityapp.presentation.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.charityapp.presentation.views.AuthorizationView

@InjectViewState
class AuthorizationPresenter : MvpPresenter<AuthorizationView>() {

    override fun attachView(view: AuthorizationView?) {
        super.attachView(view)
        viewState.validate()
        viewState.navigate()
    }
}