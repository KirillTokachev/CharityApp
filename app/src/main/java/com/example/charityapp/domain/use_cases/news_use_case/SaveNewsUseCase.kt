package com.example.charityapp.domain.use_cases.news_use_case

import com.example.charityapp.domain.model.News

interface SaveNewsUseCase {

    suspend fun saveNews(news: List<News>)
}