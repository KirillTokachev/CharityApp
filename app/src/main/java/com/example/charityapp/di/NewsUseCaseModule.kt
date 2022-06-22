package com.example.charityapp.di

import com.example.charityapp.data.use_case_impls.news.LoadNewsUseCaseImpl
import com.example.charityapp.data.use_case_impls.news.SaveNewsUseCaseImpl
import com.example.charityapp.domain.use_cases.news_use_case.LoadNewsUseCase
import com.example.charityapp.domain.use_cases.news_use_case.SaveNewsUseCase
import dagger.Binds
import dagger.Module

@Module
interface NewsUseCaseModule {

    @Binds
    @ApplicationScope
    fun bindLoadNewsUseCase(impl: LoadNewsUseCaseImpl): LoadNewsUseCase

    @Binds
    @ApplicationScope
    fun bindSaveNewsUseCase(impl: SaveNewsUseCaseImpl): SaveNewsUseCase
}