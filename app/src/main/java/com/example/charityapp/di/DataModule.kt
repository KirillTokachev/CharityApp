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

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindNewsRepository(impl: NewsRepositoryImpl): NewsRepository

    @Binds
    @ApplicationScope
    fun bindHelpCategoryRepository(impl: HelpCategoryRepositoryImpl): HelpCategoryRepository

    companion object {

        @Provides
        @ApplicationScope
        fun provideNewsDao(application: Application): NewsDao {
            return AppDataBase.getInstance(application).getNewsDao()
        }

        @Provides
        @ApplicationScope
        fun provideHelpCategoryDao(application: Application): HelpCategoryDao {
            return AppDataBase.getInstance(application).getHelpCategoryDao()
        }

        @Provides
        @ApplicationScope
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }
    }
}