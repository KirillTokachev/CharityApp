package com.example.charityapp.domain.use_cases.event_use_case

import com.example.charityapp.domain.repository.EventRepository

interface GetSearchResultTitleUseCase {

    fun getSearchResultTitle(): String
}