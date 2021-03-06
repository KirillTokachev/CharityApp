package com.example.charityapp.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface HelpCategoryDao {

    @Query("SELECT * FROM ${DbUtil.HELP_CATEGORY}")
    suspend fun loadHelpList(): List<HelpCategoryDbModel>

    @Insert(entity = HelpCategoryDbModel::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveHelps(help: List<HelpCategoryDbModel>)
}
