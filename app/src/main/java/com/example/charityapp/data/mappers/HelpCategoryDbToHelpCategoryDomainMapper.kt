package com.example.charityapp.data.mappers

import com.example.charityapp.data.database.HelpCategoryDbModel
import com.example.charityapp.domain.model.HelpCategory
import javax.inject.Inject

class HelpCategoryDbToHelpCategoryDomainMapper @Inject constructor() :
        (HelpCategoryDbModel) -> HelpCategory {

    override fun invoke(dbModel: HelpCategoryDbModel) =
        with(dbModel) {
            HelpCategory(
                id = id,
                name = name,
                icon = icon
            )
        }
}