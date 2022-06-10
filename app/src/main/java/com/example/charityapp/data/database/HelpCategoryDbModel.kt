package com.example.charityapp.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "help_category")
data class HelpCategoryDbModel(
    @PrimaryKey val id: Long,
    val name: String,
    val icon: String
)