package com.example.charityapp.domain.use_cases.event_use_case

import com.example.charityapp.domain.repository.EventRepository

class GetSearchResultTitleUseCase(
    private val repository: EventRepository
) {

    operator fun invoke() = repository.getSearchResultTitle()
}