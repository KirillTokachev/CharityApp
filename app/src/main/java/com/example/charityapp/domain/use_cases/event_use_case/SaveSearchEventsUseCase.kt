package com.example.charityapp.domain.use_cases.event_use_case

import com.example.charityapp.domain.model.Event
import com.example.charityapp.domain.repository.EventRepository

class SaveSearchEventsUseCase(
    private val repository: EventRepository
) {

    fun saveSearchEvents(events: List<Event>) {
        repository.saveSearchEvents(events)
    }
}