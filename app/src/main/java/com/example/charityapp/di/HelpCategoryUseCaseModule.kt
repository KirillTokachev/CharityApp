package com.example.charityapp.di

import com.example.charityapp.data.use_case_impls.help_category.LoadHelpListUseCaseImpl
import com.example.charityapp.data.use_case_impls.help_category.SaveHelpsUseCaseImpl
import com.example.charityapp.domain.use_cases.help_category_use_case.LoadHelpListUseCase
import com.example.charityapp.domain.use_cases.help_category_use_case.SaveHelpsUseCase
import dagger.Binds
import dagger.Module

@Module
interface HelpCategoryUseCaseModule {

    @Binds
    @ApplicationScope
    fun bindLoadHelpListUseCase(impl: LoadHelpListUseCaseImpl): LoadHelpListUseCase

    @Binds
    @ApplicationScope
    fun bindSaveHelpListUseCase(impl: SaveHelpsUseCaseImpl): SaveHelpsUseCase
}