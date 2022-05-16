package com.example.charityapp.domain.model

import androidx.annotation.DrawableRes
import org.threeten.bp.LocalDate

data class User(
    val name: String,
    val dateOfBirth: LocalDate,
    val profession: String,
    @DrawableRes val avatar: Int,
    val friends: List<User>,
    // Поле которое даёт понять, стоит пуш уведомление у пользователя или нет
    val push: Boolean = false
)
