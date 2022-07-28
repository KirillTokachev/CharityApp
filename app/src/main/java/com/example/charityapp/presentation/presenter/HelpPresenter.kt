package com.example.charityapp.presentation.presenter

import android.widget.ProgressBar
import androidx.core.view.isVisible
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.charityapp.data.mappers.JsonMapper
import com.example.charityapp.data.use_case_impls.api_service.GetHelpCategoryUseCaseImpl
import com.example.charityapp.data.use_case_impls.help_category.LoadHelpListUseCaseImpl
import com.example.charityapp.data.use_case_impls.help_category.SaveHelpsUseCaseImpl
import com.example.charityapp.domain.model.HelpCategory
import com.example.charityapp.presentation.views.HelpView
import javax.inject.Inject

@InjectViewState
class HelpPresenter @Inject constructor(
    private val loadHelpListUseCase: LoadHelpListUseCaseImpl,
    private val saveHelpListUseCase: SaveHelpsUseCaseImpl,
    private val getGetHelpCategoryUseCase: GetHelpCategoryUseCaseImpl,
    private val jsonMapper: JsonMapper
) : MvpPresenter<HelpView>() {

    suspend fun loadNetworkData() {
        when (getGetHelpCategoryUseCase.fetchHelpCategory().isEmpty()) {
            true -> {
                saveHelpListUseCase.saveHelps(jsonMapper.getCategory())
            }
            false -> {
                saveHelpListUseCase.saveHelps(
                    getGetHelpCategoryUseCase.fetchHelpCategory()
                )
            }
        }
    }

    suspend fun loadHelp(): List<HelpCategory> {
        return loadHelpListUseCase.loadHelpList()
    }

    suspend fun isVisibleProgressBar(progressBar: ProgressBar) {
        progressBar.isVisible = getGetHelpCategoryUseCase.fetchHelpCategory().isEmpty()
    }
}