package com.example.charityapp.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NewsDao {

    @Query("SELECT * FROM DBUtil.news")
    suspend fun loadNews(): List<NewsDbModel>

    @Insert(entity = NewsDbModel::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveNews(news: List<NewsDbModel>)
}