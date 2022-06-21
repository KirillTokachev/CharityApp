package com.example.charityapp.data.network

import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {

    @GET(GETS.CATEGORIES)
    @Headers("Content-Type: application/json")
    suspend fun getHelpCategoryList(): List<HelpCategoryNet>

    @GET(GETS.NEWS)
    @Headers("Content-Type: application/json")
    suspend fun getNewsList(): List<NewsNet>
}