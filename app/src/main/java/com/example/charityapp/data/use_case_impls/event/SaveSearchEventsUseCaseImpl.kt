package com.example.charityapp.data.use_case_impls.event

import com.example.charityapp.domain.model.Event
import com.example.charityapp.domain.repository.EventRepository
import com.example.charityapp.domain.use_cases.event_use_case.SaveSearchEventsUseCase

class SaveSearchEventsUseCaseImpl(
    private val repository: EventRepository
) : SaveSearchEventsUseCase {

    override fun saveSearchEvents(events: List<Event>) {
        repository.saveSearchEvents(events)
    }
}