package com.example.charityapp.data.use_case_impls.news

import com.example.charityapp.domain.model.News
import com.example.charityapp.domain.repository.NewsRepository
import com.example.charityapp.domain.use_cases.news_use_case.LoadNewsUseCase

class LoadNewsUseCaseImpl(
    private val repository: NewsRepository
) : LoadNewsUseCase {

    override suspend fun loadNews(): List<News> {
        return repository.loadNews()
    }
}