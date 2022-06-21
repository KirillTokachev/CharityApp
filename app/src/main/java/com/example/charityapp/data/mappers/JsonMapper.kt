package com.example.charityapp.data.mappers

import android.content.Context
import android.content.res.AssetManager
import com.example.charityapp.data.network.HelpCategoryNet
import com.example.charityapp.data.network.NewsNet
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class JsonMapper(private val context: Context) {

    companion object {
        private const val NEWS_PATH = "news.json"
        private const val CATEGORY_PATH = "category.json"
    }

    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    private val typeNews = Types.newParameterizedType(List::class.java, NewsNet::class.java)
    private val newsAdapter = moshi.adapter<List<NewsNet>>(typeNews)
    private val typeCategory =
        Types.newParameterizedType(List::class.java, HelpCategoryNet::class.java)
    private val categoryAdapter = moshi.adapter<List<HelpCategoryNet>>(typeCategory)

    private fun AssetManager.readFile(fileName: String): String =
        open(fileName).bufferedReader().use { it.readText() }

    fun getNews(): List<NewsNet> {
        val jsonNews = context.assets.readFile(NEWS_PATH)
        val news = newsAdapter.fromJson(jsonNews)!!
        return news.toList()
    }

    fun getCategory(): List<HelpCategoryNet> {
        val jsonCategory = context.assets.readFile(CATEGORY_PATH)
        val category = categoryAdapter.fromJson(jsonCategory)!!
        return category.toList()
    }
}