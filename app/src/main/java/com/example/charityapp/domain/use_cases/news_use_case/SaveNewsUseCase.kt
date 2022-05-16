package com.example.charityapp.domain.use_cases.news_use_case

import com.example.charityapp.domain.model.News
import com.example.charityapp.domain.repository.NewsRepository

class SaveNewsUseCase(
    private val repository: NewsRepository
) {

    suspend fun saveNews(news: List<News>) {
        return repository.saveNews(news)
    }
}