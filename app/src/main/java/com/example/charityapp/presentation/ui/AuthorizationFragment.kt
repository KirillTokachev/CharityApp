package com.example.charityapp.presentation.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CheckResult
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.charityapp.R
import com.example.charityapp.databinding.FragmentAuthorizationBinding
import com.example.charityapp.presentation.presenter.AuthorizationPresenter
import com.example.charityapp.presentation.views.AuthorizationView
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*

const val MIN_SYMBOLS = 5

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
        val emailFlow = binding.textInputEditTextEmail.textChanges().debounce(300)
        val passwordFlow = binding.textInputEditTextPassword.textChanges().debounce(300)
            .combine(emailFlow) { s1, s2 ->
                binding.buttonAuthorization.isEnabled =
                    s1.toString().length > MIN_SYMBOLS && s2.toString().length > MIN_SYMBOLS

            }.launchIn(lifecycleScope)
    }

    override fun navigate() {
        binding.buttonAuthorization.setOnClickListener {
            findNavController().navigate(R.id.action_authorizationFragment_to_helpFragment)
        }
    }

    @ExperimentalCoroutinesApi
    @CheckResult
    private fun TextInputEditText.textChanges(): Flow<CharSequence?> {
        return callbackFlow<CharSequence?> {
            val listener = object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    trySend(p0)
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit
                override fun afterTextChanged(p0: Editable?) = Unit
            }
            addTextChangedListener(listener)
            awaitClose { removeTextChangedListener(listener) }
        }.onStart { emit(text) }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}