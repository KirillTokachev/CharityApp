package com.example.charityapp.data.use_case_impls.event

import com.example.charityapp.domain.repository.EventRepository
import com.example.charityapp.domain.use_cases.event_use_case.GetSearchResultTitleUseCase

class GetSearchResultTitleUseCaseImpl(
    private val repository: EventRepository
) : GetSearchResultTitleUseCase {

    override fun getSearchResultTitle(): String {
        return repository.getSearchResultTitle()
    }
}