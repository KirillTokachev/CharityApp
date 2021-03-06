package com.example.charityapp.data.mappers

import com.example.charityapp.data.database.NewsDbModel
import com.example.charityapp.domain.model.News
import javax.inject.Inject

class NewsDomainToNewsDbMapper @Inject constructor() : (News) -> NewsDbModel {

    override fun invoke(entity: News) =
        with(entity) {
            NewsDbModel(
                id = id,
                name = name,
                avatarNews = avatarNews,
                description = description,
                dateStart = dateStart,
                dateEnd = dateEnd,
                helpCategory = helpCategory,
                fullDescription = fullDescription,
                newsImages = newsImages,
                address = address,
                phone = phone,
                company = company,
                read = read
            )
        }
}