package com.example.charityapp.domain.use_cases.api_use_case

import com.example.charityapp.domain.model.News

interface GetNewsUseCase {

    suspend fun fetchNews(): List<News>
}