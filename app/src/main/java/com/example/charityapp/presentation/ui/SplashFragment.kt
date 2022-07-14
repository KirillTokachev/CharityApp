package com.example.charityapp.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.charityapp.R
import com.example.charityapp.presentation.presenter.SplashPresenter
import com.example.charityapp.presentation.views.SplashView

private const val TIME_SLEEP: Long = 1700

class Splash : MvpAppCompatFragment(), SplashView {

    @InjectPresenter
    lateinit var presenter: SplashPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun downloading() {
        presenter.sleep(TIME_SLEEP)
        findNavController().navigate(
            R.id.action_splashFragment_to_mainFragment, bundleOf(),
            navOptions {
                launchSingleTop = true
                popUpTo(R.id.app_nav_graph) {
                    inclusive = true
                }
            }
        )
    }
}