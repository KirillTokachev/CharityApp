package com.example.charityapp.di

import android.app.Application
import com.example.charityapp.data.database.AppDataBase
import com.example.charityapp.data.database.HelpCategoryDao
import com.example.charityapp.data.repository.HelpCategoryRepositoryImpl
import com.example.charityapp.domain.repository.HelpCategoryRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface HelpCategoryModule {

    @Binds
    fun bindHelpCategoryRepository(impl: HelpCategoryRepositoryImpl): HelpCategoryRepository

    @Provides
    fun provideHelpCategoryDao(application: Application): HelpCategoryDao {
        return AppDataBase.getInstance(application).getHelpCategoryDao()
    }
}