package com.example.charityapp.domain.use_cases.api_use_case

import com.example.charityapp.domain.model.HelpCategory

interface GetHelpCategoryUseCase {

    suspend fun fetchHelpCategory(): List<HelpCategory>
}