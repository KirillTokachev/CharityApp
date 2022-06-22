package com.example.charityapp.data.mappers

import com.example.charityapp.data.database.NewsDbModel
import com.example.charityapp.data.network.NewsNet

class NewsNetToNewsDbMapper constructor() : (NewsNet) -> NewsDbModel {

    override fun invoke(net: NewsNet) =
        with(net) {
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