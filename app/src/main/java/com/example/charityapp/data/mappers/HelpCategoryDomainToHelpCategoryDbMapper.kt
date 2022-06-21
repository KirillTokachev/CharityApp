package com.example.charityapp.data.mappers

import com.example.charityapp.data.database.HelpCategoryDbModel
import com.example.charityapp.domain.model.HelpCategory

class HelpCategoryDomainToHelpCategoryDbMapper constructor() :
        (HelpCategory) -> HelpCategoryDbModel {

    override fun invoke(entity: HelpCategory) =
        HelpCategoryDbModel(
            id = entity.id,
            name = entity.name,
            icon = entity.icon
        )
}