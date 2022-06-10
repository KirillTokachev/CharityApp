package com.example.charityapp.data.database

import androidx.room.TypeConverter

class ListToStringConverter {

    @TypeConverter
    fun fromListHelpCategory(helpCategory: List<String>): String {
        return helpCategory.joinToString(",")
    }

    @TypeConverter
    fun toListHelpCategory(helpCategory: String): List<String> {
        return helpCategory.split(",")
    }
}