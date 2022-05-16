package com.example.charityapp.domain.use_cases.event_use_case

import com.example.charityapp.domain.model.Event
import com.example.charityapp.domain.repository.EventRepository

class LoadEventsUseCase(
    private val repository: EventRepository
) {

    fun loadEvents(): List<Event> {
        return repository.loadEvents()
    }
}