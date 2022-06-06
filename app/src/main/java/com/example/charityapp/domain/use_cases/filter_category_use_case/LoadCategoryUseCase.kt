package com.example.charityapp.domain.use_cases.filter_category_use_case

import com.example.charityapp.domain.model.FilterCategory
import com.example.charityapp.domain.repository.FilterCategoryRepository

interface LoadCategoryUseCase {

    fun loadCategory(): List<FilterCategory>
}