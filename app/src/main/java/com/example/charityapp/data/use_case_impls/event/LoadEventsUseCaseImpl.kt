package com.example.charityapp.data.use_case_impls.event

import com.example.charityapp.domain.model.Event
import com.example.charityapp.domain.repository.EventRepository
import com.example.charityapp.domain.use_cases.event_use_case.LoadEventsUseCase

class LoadEventsUseCaseImpl(
    private val repository: EventRepository
) : LoadEventsUseCase {

    override fun loadEvents(): List<Event> {
        return repository.loadEvents()
    }
}