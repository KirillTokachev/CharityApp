package com.example.charityapp.domain.use_cases.user_use_case

import com.example.charityapp.domain.model.User

interface LoadUserDataUseCase {

    fun loadUserData(): User
}