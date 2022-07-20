package com.example.charityapp.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.charityapp.R
import com.example.charityapp.databinding.FragmentAuthorizationBinding
import com.example.charityapp.presentation.presenter.AuthorizationPresenter
import com.example.charityapp.presentation.views.AuthorizationView

class AuthorizationFragment : MvpAppCompatFragment(), AuthorizationView {

    private var _binding: FragmentAuthorizationBinding? = null
    private val binding
        get() = _binding ?: throw NullPointerException("FragmentAuthorizationBinding is null")

    @InjectPresenter
    lateinit var presenter: AuthorizationPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAuthorizationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun validate() {
        presenter.validateAuthorization(
            binding.textInputEditTextEmail,
            binding.textInputEditTextPassword,
            binding.buttonAuthorization,
            viewLifecycleOwner
        )
    }

    override fun setupNavigateClickListener() {
        binding.buttonAuthorization.setOnClickListener {
            findNavController().navigate(R.id.action_authorizationFragment_to_helpFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}