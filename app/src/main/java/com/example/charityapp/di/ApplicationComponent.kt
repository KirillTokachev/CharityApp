package com.example.charityapp.di

import android.app.Application
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

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}