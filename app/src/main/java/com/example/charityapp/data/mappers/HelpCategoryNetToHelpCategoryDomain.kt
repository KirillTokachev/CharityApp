package com.example.charityapp.data.mappers

import com.example.charityapp.data.network.HelpCategoryNet
import com.example.charityapp.domain.model.HelpCategory
import javax.inject.Inject

class HelpCategoryNetToHelpCategoryDomain @Inject constructor() :
        (HelpCategoryNet) -> HelpCategory {

    override fun invoke(net: HelpCategoryNet) =
        with(net) {
            HelpCategory(
                id = id,
                name = name,
                icon = icon
            )
        }
}