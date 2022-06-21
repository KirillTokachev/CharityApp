package com.example.charityapp.data.database

import androidx.room.TypeConverter

class ListToStringConverter {

    companion object {

        private const val COMMA = ","
    }

    @TypeConverter
    fun fromListHelpCategory(helpCategory: List<String>): String {
        return helpCategory.joinToString(COMMA)
    }

    @TypeConverter
    fun toListHelpCategory(helpCategory: String): List<String> {
        return helpCategory.split(COMMA)
    }
}