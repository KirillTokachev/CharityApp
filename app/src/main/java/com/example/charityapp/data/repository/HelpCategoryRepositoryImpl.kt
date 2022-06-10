package com.example.charityapp.data.repository

import com.example.charityapp.data.database.HelpCategoryDao
import com.example.charityapp.data.mappers.HelpCategoryMapper
import com.example.charityapp.domain.model.HelpCategory
import com.example.charityapp.domain.repository.HelpCategoryRepository

class HelpCategoryRepositoryImpl(
    private val mapper: HelpCategoryMapper,
    private val helpCategoryDao: HelpCategoryDao
) : HelpCategoryRepository {

    override suspend fun loadHelpList(): List<HelpCategory> {
        return helpCategoryDao.loadHelpList().map {
            mapper.mapHelpCategoryDbModelToHelpCategory(it)
        }
    }

    override suspend fun saveHelps(helpsList: List<HelpCategory>) {
        helpCategoryDao.saveHelps(
            helpsList.map {
                mapper.mapHelpCategoryToHelpCategoryDbModel(it)
            }
        )
    }
}