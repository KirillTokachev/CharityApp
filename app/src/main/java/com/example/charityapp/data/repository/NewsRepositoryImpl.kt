package com.example.charityapp.data.repository

import com.example.charityapp.data.database.NewsDao
import com.example.charityapp.data.mappers.NewsDbToNewsDomainMapper
import com.example.charityapp.data.mappers.NewsDomainToNewsDbMapper
import com.example.charityapp.domain.model.News
import com.example.charityapp.domain.repository.NewsRepository

class NewsRepositoryImpl(
    private val newsDao: NewsDao,
    private val newsDbToNewsDomainMapper: NewsDbToNewsDomainMapper,
    private val newsDomainToNewsDbMapper: NewsDomainToNewsDbMapper
) : NewsRepository {

    override suspend fun loadNews(): List<News> {
        return newsDao.loadNews().map(newsDbToNewsDomainMapper)
    }

    override suspend fun saveNews(news: List<News>) {
        newsDao.saveNews(
            news.map(newsDomainToNewsDbMapper)
        )
    }
}