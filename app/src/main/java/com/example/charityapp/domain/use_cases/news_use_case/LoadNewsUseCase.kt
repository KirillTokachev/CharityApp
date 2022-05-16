package com.example.charityapp.domain.use_cases.news_use_case

import com.example.charityapp.domain.model.News
import com.example.charityapp.domain.repository.NewsRepository

class LoadNewsUseCase(
    private val repository: NewsRepository
) {

    suspend fun loadNews(): List<News> {
        return repository.loadNews()
    }
}