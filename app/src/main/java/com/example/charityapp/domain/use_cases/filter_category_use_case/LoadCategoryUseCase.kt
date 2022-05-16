package com.example.charityapp.domain.use_cases.filter_category_use_case

import com.example.charityapp.domain.repository.FilterCategoryRepository

class LoadCategoryUseCase(
    private val repository: FilterCategoryRepository
) {

    operator fun invoke() = repository.loadCategory()
}