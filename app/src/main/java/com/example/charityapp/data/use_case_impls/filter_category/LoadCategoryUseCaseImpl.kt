package com.example.charityapp.data.use_case_impls.filter_category

import com.example.charityapp.domain.model.FilterCategory
import com.example.charityapp.domain.repository.FilterCategoryRepository
import com.example.charityapp.domain.use_cases.filter_category_use_case.LoadCategoryUseCase

class LoadCategoryUseCaseImpl(
    private val repository: FilterCategoryRepository
) : LoadCategoryUseCase {

    override fun loadCategory(): List<FilterCategory> {
        return repository.loadCategory()
    }
}