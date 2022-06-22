package com.example.charityapp.data.repository

import com.example.charityapp.data.database.HelpCategoryDao
import com.example.charityapp.data.mappers.HelpCategoryDbToHelpCategoryDomainMapper
import com.example.charityapp.data.mappers.HelpCategoryDomainToHelpCategoryDbMapper
import com.example.charityapp.domain.model.HelpCategory
import com.example.charityapp.domain.repository.HelpCategoryRepository
import javax.inject.Inject

class HelpCategoryRepositoryImpl @Inject constructor(
    private val helpCategoryDao: HelpCategoryDao,
    private val helpCategoryDomainToHelpCategoryDbMapper: HelpCategoryDomainToHelpCategoryDbMapper,
    private val helpCategoryDbToHelpCategoryDomainMapper: HelpCategoryDbToHelpCategoryDomainMapper
) : HelpCategoryRepository {

    override suspend fun loadHelpList(): List<HelpCategory> {
        return helpCategoryDao.loadHelpList().map(helpCategoryDbToHelpCategoryDomainMapper)
    }

    override suspend fun saveHelps(helpsList: List<HelpCategory>) {
        helpCategoryDao.saveHelps(
            helpsList.map(helpCategoryDomainToHelpCategoryDbMapper)
        )
    }
}