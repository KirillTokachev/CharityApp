package com.example.charityapp.di

import android.app.Application
import com.example.charityapp.presentation.CharityApplication
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        NewsUseCaseModule::class,
        HelpCategoryUseCaseModule::class
    ]
)
interface ApplicationComponent {

    fun inject(application: CharityApplication)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}