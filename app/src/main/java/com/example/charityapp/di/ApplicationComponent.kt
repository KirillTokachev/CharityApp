package com.example.charityapp.di

import android.app.Application
import android.content.Context
import com.example.charityapp.presentation.ui.HelpFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NewsModule::class,
        HelpCategoryModule::class,
        ApiServiceModule::class,
        NewsUseCaseModule::class,
        HelpCategoryUseCaseModule::class
    ]
)
interface ApplicationComponent {

    fun inject(fragment: HelpFragment)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application,
            @BindsInstance context: Context
        ): ApplicationComponent
    }
}