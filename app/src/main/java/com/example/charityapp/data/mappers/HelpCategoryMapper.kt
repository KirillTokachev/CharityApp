package com.example.charityapp.data.mappers

import com.example.charityapp.data.database.HelpCategoryDbModel
import com.example.charityapp.data.network.HelpCategoryDto
import com.example.charityapp.domain.model.HelpCategory

class HelpCategoryMapper {

    fun mapHelpCategoryDtoToHelpCategoryDbModel(dto: HelpCategoryDto) =
        HelpCategoryDbModel(
            id = dto.id,
            name = dto.name,
            icon = dto.icon
        )

    fun mapHelpCategoryToHelpCategoryDbModel(entity: HelpCategory) =
        HelpCategoryDbModel(
            id = entity.id,
            name = entity.name,
            icon = entity.icon
        )

    fun mapHelpCategoryDbModelToHelpCategory(dbModel: HelpCategoryDbModel) =
        HelpCategory(
            id = dbModel.id,
            name = dbModel.name,
            icon = dbModel.icon
        )
}