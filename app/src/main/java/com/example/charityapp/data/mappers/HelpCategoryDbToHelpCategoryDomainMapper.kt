package com.example.charityapp.data.mappers

import com.example.charityapp.data.database.HelpCategoryDbModel
import com.example.charityapp.domain.model.HelpCategory

class HelpCategoryDbToHelpCategoryDomainMapper constructor() :
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