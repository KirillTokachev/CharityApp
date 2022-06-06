package com.example.charityapp.domain.repository

import com.example.charityapp.domain.model.User

interface UserRepository {

    fun loadUserData(): User
}