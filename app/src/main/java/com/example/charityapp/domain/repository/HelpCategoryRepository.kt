package com.example.charityapp.domain.repository

import com.example.charityapp.domain.model.HelpCategory

interface HelpCategoryRepository {

    suspend fun loadHelpList(): List<HelpCategory>

    suspend fun saveHelps(helpsList: List<HelpCategory>)
}