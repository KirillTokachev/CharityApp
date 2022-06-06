package com.example.charityapp.domain.repository

import com.example.charityapp.domain.model.News

interface NewsRepository {

    suspend fun loadNews(): List<News>

    suspend fun saveNews(news: List<News>)
}