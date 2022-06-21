package com.example.charityapp.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = DbUtil.HELP_CATEGORY)
data class HelpCategoryDbModel(
    @PrimaryKey val id: Long,
    val name: String,
    val icon: String
)