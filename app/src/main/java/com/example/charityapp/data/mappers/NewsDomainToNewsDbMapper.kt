package com.example.charityapp.data.mappers

import com.example.charityapp.data.database.NewsDbModel
import com.example.charityapp.domain.model.News

class NewsDomainToNewsDbMapper constructor() : (News) -> NewsDbModel {

    override fun invoke(entity: News) =
        NewsDbModel(
            id = entity.id,
            name = entity.name,
            avatarNews = entity.avatarNews,
            description = entity.description,
            dateStart = entity.dateStart,
            dateEnd = entity.dateEnd,
            helpCategory = entity.helpCategory,
            fullDescription = entity.fullDescription,
            newsImages = entity.newsImages,
            address = entity.address,
            phone = entity.phone,
            company = entity.company,
            read = entity.read
        )
}