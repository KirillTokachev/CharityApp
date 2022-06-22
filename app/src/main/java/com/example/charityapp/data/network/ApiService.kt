package com.example.charityapp.data.network

import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {

    @GET(Gets.CATEGORIES)
    @Headers("Content-Type: application/json")
    suspend fun getHelpCategoryList(): List<HelpCategoryNet>

    @GET(Gets.NEWS)
    @Headers("Content-Type: application/json")
    suspend fun getNewsList(): List<NewsNet>
}