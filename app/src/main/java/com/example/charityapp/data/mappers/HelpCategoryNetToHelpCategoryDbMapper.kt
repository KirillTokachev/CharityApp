package com.example.charityapp.data.mappers

import com.example.charityapp.data.database.HelpCategoryDbModel
import com.example.charityapp.data.network.HelpCategoryNet

class HelpCategoryNetToHelpCategoryDbMapper constructor() :
        (HelpCategoryNet) -> HelpCategoryDbModel {

    override fun invoke(net: HelpCategoryNet) =
        with(net) {
            HelpCategoryDbModel(
                id = id,
                name = name,
                icon = icon
            )
        }
}