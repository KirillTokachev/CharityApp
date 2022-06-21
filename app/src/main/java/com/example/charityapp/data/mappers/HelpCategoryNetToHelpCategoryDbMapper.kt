package com.example.charityapp.data.mappers

import com.example.charityapp.data.database.HelpCategoryDbModel
import com.example.charityapp.data.network.HelpCategoryNet

class HelpCategoryNetToHelpCategoryDbMapper constructor() :
        (HelpCategoryNet) -> HelpCategoryDbModel {

    override fun invoke(net: HelpCategoryNet) =
        HelpCategoryDbModel(
            id = net.id,
            name = net.name,
            icon = net.icon
        )
}