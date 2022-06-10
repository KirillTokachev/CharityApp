package com.example.charityapp.data.mappers

import com.example.charityapp.data.database.NewsDbModel
import com.example.charityapp.data.network.NewsDto
import com.example.charityapp.domain.model.News

class NewsMapper {

    fun mapNewsDtoToDbModel(dto: NewsDto) =
        NewsDbModel(
            id = dto.id,
            name = dto.name,
            avatarNews = dto.avatarNews,
            description = dto.description,
            dateStart = dto.dateStart,
            dateEnd = dto.dateEnd,
            helpCategory = dto.helpCategory,
            fullDescription = dto.fullDescription,
            newsImages = dto.newsImages,
            address = dto.address,
            phone = dto.phone,
            company = dto.company,
            read = dto.read
        )

    fun mapNewsToNewsDbModel(entity: News) =
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

    fun mapNewsDbModelToNews(dbModel: NewsDbModel) =
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