package com.example.charityapp.data.use_case_impls.user

import com.example.charityapp.domain.model.User
import com.example.charityapp.domain.repository.UserRepository
import com.example.charityapp.domain.use_cases.user_use_case.LoadUserDataUseCase

class LoadUserDataUseCaseImpl(
    private val repository: UserRepository
) : LoadUserDataUseCase {

    override fun loadUserData(): User {
        return repository.loadUserData()
    }
}