package com.example.charityapp.domain.use_cases.user_use_case

import com.example.charityapp.domain.repository.UserRepository

class LoadUserDataUseCase(
    private val repository: UserRepository
) {

    operator fun invoke() = repository.loadUserData()
}