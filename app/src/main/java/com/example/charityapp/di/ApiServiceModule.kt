package com.example.charityapp.di

import com.example.charityapp.data.network.ApiFactory
import com.example.charityapp.data.network.ApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
interface ApiServiceModule {

    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return ApiFactory.apiService
    }
}