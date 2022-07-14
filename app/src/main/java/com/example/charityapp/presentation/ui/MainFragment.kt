package com.example.charityapp.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.charityapp.R
import com.example.charityapp.databinding.FragmentMainBinding
import com.example.charityapp.presentation.presenter.MainPresenter
import com.example.charityapp.presentation.views.MainView

private const val GONE = View.GONE
private const val VISIBLE = View.VISIBLE

class Main : MvpAppCompatFragment(), MainView {
    private var _binding: FragmentMainBinding? = null
    private val binding
        get() = _binding ?: throw NumberFormatException("FragmentMainBinding is null")

    @InjectPresenter
    lateinit var mainPresenter: MainPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun setUpNavigation() {
        val navController =
            (childFragmentManager.findFragmentById(R.id.main_container_view) as? NavHostFragment)?.navController
        if (navController != null) {
            setupWithNavController(binding.bottomNavigation, navController)
        }

        binding.bottomNavigation.apply {
            background = null
            menu.getItem(2).isEnabled = false
            selectedItemId = R.id.helpFragment
        }

        binding.fbHelp.setOnClickListener {
            navController?.navigate(R.id.helpFragment)
            binding.bottomNavigation.selectedItemId = R.id.helpFragment
        }

        navController?.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                // Пока эти фрагменты закоминчены потому что не реализованы
                // R.id.cameraFragment -> setupBottomNavVisible(GONE)
                // R.id.detailFragment -> setupBottomNavVisible(GONE)
                R.id.authorizationFragment -> setupBottomNavVisible(GONE)
                else -> setupBottomNavVisible(VISIBLE)
            }
        }
    }

    private fun setupBottomNavVisible(visibility: Int) {
        with(binding) {
            bottomAppBar.visibility = visibility
            bottomNavigation.visibility = visibility
            fbHelp.visibility = visibility
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}