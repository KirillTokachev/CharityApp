package com.example.charityapp.data.mappers

import com.example.charityapp.data.database.NewsDbModel
import com.example.charityapp.data.network.NewsNet

class NewsNetToNewsDbMapper constructor() : (NewsNet) -> NewsDbModel {

    override fun invoke(net: NewsNet) =
        NewsDbModel(
            id = net.id,
            name = net.name,
            avatarNews = net.avatarNews,
            description = net.description,
            dateStart = net.dateStart,
            dateEnd = net.dateEnd,
            helpCategory = net.helpCategory,
            fullDescription = net.fullDescription,
            newsImages = net.newsImages,
            address = net.address,
            phone = net.phone,
            company = net.company,
            read = net.read
        )
}