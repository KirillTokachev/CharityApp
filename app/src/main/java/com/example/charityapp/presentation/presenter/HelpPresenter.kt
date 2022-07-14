package com.example.charityapp.presentation.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.charityapp.data.mappers.HelpCategoryNetToHelpCategoryDomain
import com.example.charityapp.data.mappers.JsonMapper
import com.example.charityapp.data.network.ApiService
import com.example.charityapp.data.use_case_impls.help_category.LoadHelpListUseCaseImpl
import com.example.charityapp.data.use_case_impls.help_category.SaveHelpsUseCaseImpl
import com.example.charityapp.domain.model.HelpCategory
import com.example.charityapp.presentation.views.HelpView
import javax.inject.Inject

@InjectViewState
class HelpPresenter @Inject constructor(
    private val loadHelpListUseCase: LoadHelpListUseCaseImpl,
    private val saveHelpListUseCase: SaveHelpsUseCaseImpl,
    private val helpCategoryNetToHelpCategoryDomain: HelpCategoryNetToHelpCategoryDomain,
    private val apiService: ApiService,
    private val jsonMapper: JsonMapper
) : MvpPresenter<HelpView>() {

    suspend fun loadNetworkData() {
        when (apiService.getHelpCategoryList().isEmpty()) {
            true -> {
                saveHelpListUseCase.saveHelps(jsonMapper.getCategory())
            }
            false -> {
                saveHelpListUseCase.saveHelps(
                    apiService.getHelpCategoryList().map {
                        helpCategoryNetToHelpCategoryDomain(it)
                    }
                )
            }
        }
    }

    suspend fun loadHelp(): List<HelpCategory> {
        return loadHelpListUseCase.loadHelpList()
    }
}