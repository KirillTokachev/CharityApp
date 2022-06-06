package com.example.charityapp.data.use_case_impls.event

import com.example.charityapp.domain.model.Event
import com.example.charityapp.domain.repository.EventRepository
import com.example.charityapp.domain.use_cases.event_use_case.SaveEventsUseCase

class SaveEventsUseCaseImpl(
    private val repository: EventRepository
) : SaveEventsUseCase {

    override fun saveEvents(events: List<Event>) {
        repository.saveEvents(events)
    }
}