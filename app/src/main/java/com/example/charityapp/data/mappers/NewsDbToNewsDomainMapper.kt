package com.example.charityapp.data.mappers

import com.example.charityapp.data.database.NewsDbModel
import com.example.charityapp.domain.model.News

class NewsDbToNewsDomainMapper constructor() : (NewsDbModel) -> News {

    override fun invoke(dbModel: NewsDbModel) =
        News(
            id = dbModel.id,
            name = dbModel.name,
            avatarNews = dbModel.avatarNews,
            description = dbModel.description,
            dateStart = dbModel.dateStart,
            dateEnd = dbModel.dateEnd,
            helpCategory = dbModel.helpCategory,
            fullDescription = dbModel.fullDescription,
            newsImages = dbModel.newsImages,
            address = dbModel.address,
            phone = dbModel.phone,
            company = dbModel.company,
            read = dbModel.read
        )
}