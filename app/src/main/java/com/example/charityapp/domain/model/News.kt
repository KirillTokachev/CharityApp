package com.example.charityapp.domain.model

data class News(
    val id: Int,
    val name: String,
    val avatarNews: String,
    val description: String,
    val dateStart: Long,
    val dateEnd: Long,
    val helpCategory: List<String>,
    val fullDescription: String,
    val newsImages: List<String>,
    val address: String,
    val phone: String,
    val company: String,
    var read: Boolean = false
)
