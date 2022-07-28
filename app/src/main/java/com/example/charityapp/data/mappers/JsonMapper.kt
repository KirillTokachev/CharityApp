package com.example.charityapp.data.mappers

import android.content.Context
import android.content.res.AssetManager
import com.example.charityapp.data.database.HelpCategoryDbModel
import com.example.charityapp.data.database.NewsDbModel
import com.example.charityapp.domain.model.HelpCategory
import com.example.charityapp.domain.model.News
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import javax.inject.Inject

class JsonMapper @Inject constructor(private val context: Context) {

    companion object {
        private const val NEWS_PATH = "news.json"
        private const val CATEGORY_PATH = "category.json"
    }

    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    private val typeNews = Types.newParameterizedType(List::class.java, News::class.java)
    private val newsAdapter = moshi.adapter<List<News>>(typeNews)
    private val typeCategory =
        Types.newParameterizedType(List::class.java, HelpCategory::class.java)
    private val categoryAdapter = moshi.adapter<List<HelpCategory>>(typeCategory)

    private fun AssetManager.readFile(fileName: String): String =
        open(fileName).bufferedReader().use { it.readText() }

    fun getNews(): List<News> {
        val jsonNews = context.assets.readFile(NEWS_PATH)
        val news = newsAdapter.fromJson(jsonNews)!!
        return news.toList()
    }

    fun getCategory(): List<HelpCategory> {
        val jsonCategory = context.assets.readFile(CATEGORY_PATH)
        val category = categoryAdapter.fromJson(jsonCategory)!!
        return category.toList()
    }
}