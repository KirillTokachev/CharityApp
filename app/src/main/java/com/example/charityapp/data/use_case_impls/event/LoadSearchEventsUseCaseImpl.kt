package com.example.charityapp.data.use_case_impls.event

import com.example.charityapp.domain.model.Event
import com.example.charityapp.domain.repository.EventRepository
import com.example.charityapp.domain.use_cases.event_use_case.LoadSearchEventsUseCase

class LoadSearchEventsUseCaseImpl(
    private val repository: EventRepository
) : LoadSearchEventsUseCase {

    override fun loadSearchEvents(): List<Event> {
        return repository.loadSearchEvents()
    }
}