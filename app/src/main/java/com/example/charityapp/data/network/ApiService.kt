package com.example.charityapp.data.network

import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {

    @GET("./categories")
    @Headers("Content-Type: application/json")
    suspend fun getHelpCategoryList(): List<HelpCategoryDto>

    @GET("./news")
    @Headers("Content-Type: application/json")
    suspend fun getNewsList(): List<NewsDto>
}