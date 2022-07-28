package com.example.charityapp.di

import com.example.charityapp.data.network.ApiFactory
import com.example.charityapp.data.network.ApiService
import com.example.charityapp.data.use_case_impls.api_service.GetHelpCategoryUseCaseImpl
import com.example.charityapp.domain.use_cases.api_use_case.GetHelpCategoryUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
interface ApiServiceModule {

    @Binds
    fun bindGetHelpCategoryUseCase(impl: GetHelpCategoryUseCaseImpl): GetHelpCategoryUseCase

    companion object {

        @JvmStatic
        @Provides
        @Singleton
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }
    }
}