package com.example.charityapp.data.use_case_impls.help_category

import com.example.charityapp.domain.model.HelpCategory
import com.example.charityapp.domain.repository.HelpCategoryRepository
import com.example.charityapp.domain.use_cases.help_category_use_case.SaveHelpsUseCase
import javax.inject.Inject

class SaveHelpsUseCaseImpl @Inject constructor(
    private val repository: HelpCategoryRepository
) : SaveHelpsUseCase {

    override suspend fun saveHelps(helpList: List<HelpCategory>) {
        repository.saveHelps(helpList)
    }
}