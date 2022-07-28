package com.example.charityapp.di

import android.app.Application
import com.example.charityapp.data.database.AppDataBase
import com.example.charityapp.data.database.NewsDao
import com.example.charityapp.data.repository.NewsRepositoryImpl
import com.example.charityapp.domain.repository.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface NewsModule {

    @Binds
    fun bindNewsRepository(impl: NewsRepositoryImpl): NewsRepository

    companion object {

        @JvmStatic
        @Provides
        fun provideNewsDao(application: Application): NewsDao {
            return AppDataBase.getInstance(application).getNewsDao()
        }
    }
}