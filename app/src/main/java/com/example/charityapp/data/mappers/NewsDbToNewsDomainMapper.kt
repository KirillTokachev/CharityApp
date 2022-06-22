package com.example.charityapp.data.mappers

import com.example.charityapp.data.database.NewsDbModel
import com.example.charityapp.domain.model.News

class NewsDbToNewsDomainMapper constructor() : (NewsDbModel) -> News {

    override fun invoke(dbModel: NewsDbModel) =
        with(dbModel) {
            News(
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