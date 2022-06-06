package com.example.charityapp.data.use_case_impls.event

import com.example.charityapp.domain.repository.EventRepository
import com.example.charityapp.domain.use_cases.event_use_case.ClearEventsUseCase

class ClearEventsUseCaseImpl(
    private val repository: EventRepository
) : ClearEventsUseCase {

    override fun clearEvents() {
        repository.clearEvents()
    }
}