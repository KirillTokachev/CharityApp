package com.example.charityapp.domain.use_cases.help_category_use_case

import com.example.charityapp.domain.model.HelpCategory
import com.example.charityapp.domain.repository.HelpCategoryRepository

class LoadHelpListUseCase(
    private val repository: HelpCategoryRepository
) {

    suspend fun loadHelpList(): List<HelpCategory> {
        return repository.loadHelpList()
    }
}