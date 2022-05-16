package com.example.charityapp.domain.repository

import com.example.charityapp.domain.model.Event

interface EventRepository {

    fun loadEvents(): List<Event>

    fun loadSearchEvents(): List<Event>

    fun saveSearchEvents(events: List<Event>)

    fun saveEvents(events: List<Event>)

    fun getSearchResultTitle(): String

    fun clearEvents()
}