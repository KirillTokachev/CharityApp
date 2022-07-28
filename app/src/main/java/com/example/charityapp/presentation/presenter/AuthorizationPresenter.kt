package com.example.charityapp.presentation.presenter

import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import androidx.annotation.CheckResult
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.charityapp.presentation.views.AuthorizationView
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*

@InjectViewState
class AuthorizationPresenter : MvpPresenter<AuthorizationView>() {

    override fun attachView(view: AuthorizationView?) {
        super.attachView(view)
        viewState.validate()
        viewState.setupNavigateClickListener()
    }

    fun validateAuthorization(
        email: TextInputEditText,
        password: TextInputEditText,
        button: Button,
        lifecycle: LifecycleOwner
    ) {
        val emailFlow = email.textChanges().debounce(TIMEOUT)
        val passwordFlow = email.textChanges().debounce(TIMEOUT)
            .combine(emailFlow) { email, password ->
                button.isEnabled =
                    email.toString().length > MIN_SYMBOLS && password.toString().length > MIN_SYMBOLS
            }.launchIn(lifecycle.lifecycleScope)
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

    companion object {

        private const val MIN_SYMBOLS = 5
        private const val TIMEOUT = 300L
    }
}