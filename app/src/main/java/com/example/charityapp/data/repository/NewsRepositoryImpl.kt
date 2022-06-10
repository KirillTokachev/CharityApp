package com.example.charityapp.data.repository

import com.example.charityapp.data.database.NewsDao
import com.example.charityapp.data.mappers.NewsMapper
import com.example.charityapp.domain.model.News
import com.example.charityapp.domain.repository.NewsRepository

class NewsRepositoryImpl(
    private val mapper: NewsMapper,
    private val newsDao: NewsDao
) : NewsRepository {

    override suspend fun loadNews(): List<News> {
        return newsDao.loadNews().map {
            mapper.mapNewsDbModelToNews(it)
        }
    }

    override suspend fun saveNews(news: List<News>) {
        newsDao.saveNews(
            news.map {
                mapper.mapNewsToNewsDbModel(it)
            }
        )
    }
}