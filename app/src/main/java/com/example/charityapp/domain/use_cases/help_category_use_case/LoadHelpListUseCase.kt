package com.example.charityapp.domain.use_cases.help_category_use_case

import com.example.charityapp.domain.model.HelpCategory
import com.example.charityapp.domain.repository.HelpCategoryRepository

interface LoadHelpListUseCase {

    suspend fun loadHelpList(): List<HelpCategory>
}