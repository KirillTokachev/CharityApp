package com.example.charityapp.domain.model

data class News(
    val id: Long,
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
    // Данное поле выступает в качестве флага, прочитана новость или нет,для сортировки
    var read: Boolean = false
)
