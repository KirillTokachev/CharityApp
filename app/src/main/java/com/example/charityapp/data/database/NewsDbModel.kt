package com.example.charityapp.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(tableName = "news")
data class NewsDbModel(
    @PrimaryKey val id: Long,
    val name: String,
    @ColumnInfo(name = "avatar_news") val avatarNews: String,
    val description: String,
    @ColumnInfo(name = "date_start") val dateStart: Long,
    @ColumnInfo(name = "date_end") val dateEnd: Long,
    @TypeConverters(ListToStringConverter::class)
    @ColumnInfo(name = "help_category") val helpCategory: List<String>,
    @ColumnInfo(name = "full_description") val fullDescription: String,
    @TypeConverters(ListToStringConverter::class)
    @ColumnInfo(name = "news_images") val newsImages: List<String>,
    val address: String,
    val phone: String,
    val company: String,
    var read: Boolean = false
)