package com.example.charityapp.data.mappers

import com.example.charityapp.data.database.HelpCategoryDbModel
import com.example.charityapp.domain.model.HelpCategory

class HelpCategoryDomainToHelpCategoryDbMapper constructor() :
        (HelpCategory) -> HelpCategoryDbModel {

    override fun invoke(entity: HelpCategory) =
        with(entity) {
            HelpCategoryDbModel(
                id = id,
                name = name,
                icon = icon
            )
        }
}