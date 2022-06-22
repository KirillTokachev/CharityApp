package com.example.charityapp.di

import android.app.Application
import com.example.charityapp.data.database.AppDataBase
import com.example.charityapp.data.database.HelpCategoryDao
import com.example.charityapp.data.database.NewsDao
import com.example.charityapp.data.network.ApiFactory
import com.example.charityapp.data.network.ApiService
import com.example.charityapp.data.repository.HelpCategoryRepositoryImpl
import com.example.charityapp.data.repository.NewsRepositoryImpl
import com.example.charityapp.domain.repository.HelpCategoryRepository
import com.example.charityapp.domain.repository.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
interface NewsModule {

    @Binds
    fun bindNewsRepository(impl: NewsRepositoryImpl): NewsRepository

    @Provides
    fun provideNewsDao(application: Application): NewsDao {
        return AppDataBase.getInstance(application).getNewsDao()
    }
}