package com.example.charityapp.domain.repository

import com.example.charityapp.domain.model.FilterCategory

interface FilterCategoryRepository {

    fun loadCategory(): List<FilterCategory>
}