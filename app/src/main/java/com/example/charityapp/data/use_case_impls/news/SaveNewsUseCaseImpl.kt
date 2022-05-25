package com.example.charityapp.data.use_case_impls.news

import com.example.charityapp.domain.model.News
import com.example.charityapp.domain.repository.NewsRepository
import com.example.charityapp.domain.use_cases.news_use_case.SaveNewsUseCase

class SaveNewsUseCaseImpl(
    private val repository: NewsRepository
) : SaveNewsUseCase {

    override suspend fun saveNews(news: List<News>) {
        return repository.saveNews(news)
    }
}