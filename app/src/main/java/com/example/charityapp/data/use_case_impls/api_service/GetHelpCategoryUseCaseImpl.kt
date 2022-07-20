package com.example.charityapp.data.use_case_impls.api_service

import com.example.charityapp.data.mappers.HelpCategoryNetToHelpCategoryDomain
import com.example.charityapp.data.network.ApiService
import com.example.charityapp.domain.model.HelpCategory
import com.example.charityapp.domain.use_cases.api_use_case.GetHelpCategoryUseCase
import javax.inject.Inject

class GetHelpCategoryUseCaseImpl @Inject constructor(
    private val apiService: ApiService,
    private val helpCategoryNetToHelpCategoryDomain: HelpCategoryNetToHelpCategoryDomain
) : GetHelpCategoryUseCase {

    override suspend fun fetchHelpCategory(): List<HelpCategory> {
        return apiService.getHelpCategoryList().map {
            helpCategoryNetToHelpCategoryDomain(it)
        }
    }

}