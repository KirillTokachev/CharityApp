package com.example.charityapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.charityapp.data.database.DbUtil.DB_NAME

@Database(
    entities = [NewsDbModel::class, HelpCategoryDbModel::class],
    version = DbUtil.DB_VERSION,
    exportSchema = false

)
@TypeConverters(ListToStringConverter::class)
abstract class AppDataBase : RoomDatabase() {

    abstract fun getHelpCategoryDao(): HelpCategoryDao
    abstract fun getNewsDao(): NewsDao

    companion object {
        private var db: AppDataBase? = null
        private val LOCK = Any()

        fun getInstance(context: Context): AppDataBase {
            synchronized(LOCK) {
                db?.let { return it }
                val instance =
                    Room.databaseBuilder(
                        context,
                        AppDataBase::class.java,
                        DB_NAME,
                    ).fallbackToDestructiveMigration()
                        .build()
                db = instance
                return instance
            }
        }
    }
}