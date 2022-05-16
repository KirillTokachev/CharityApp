package com.example.charityapp.domain.use_cases.event_use_case

import com.example.charityapp.domain.model.Event
import com.example.charityapp.domain.repository.EventRepository

class SaveEventsUseCase(
    private val repository: EventRepository
) {

    fun saveEvents(events: List<Event>) {
        repository.saveEvents(events)
    }
}