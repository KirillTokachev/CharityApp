package com.example.charityapp.data.use_case_impls.help_category

import com.example.charityapp.domain.model.HelpCategory
import com.example.charityapp.domain.repository.HelpCategoryRepository
import com.example.charityapp.domain.use_cases.help_category_use_case.LoadHelpListUseCase
import javax.inject.Inject

class LoadHelpListUseCaseImpl @Inject constructor(
    private val repository: HelpCategoryRepository
) : LoadHelpListUseCase {

    override suspend fun loadHelpList(): List<HelpCategory> {
        return repository.loadHelpList()
    }
}