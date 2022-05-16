package com.example.charityapp.domain.model

import androidx.annotation.DrawableRes
import org.threeten.bp.LocalDate

data class User(
    val name: String,
    val dateOfBirth: LocalDate,
    val profession: String,
    @DrawableRes val avatar: Int,
    val friends: List<User>,
    val push: Boolean = false
)
