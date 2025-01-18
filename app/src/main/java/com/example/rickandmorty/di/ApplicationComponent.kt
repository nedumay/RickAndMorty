package com.example.rickandmorty.di

import android.app.Application
import com.example.rickandmorty.presentation.MainActivity
import com.example.rickandmorty.presentation.app.App
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [DataModule::class, ViewModelModule::class])
interface ApplicationComponent {

    fun inject(activity: MainActivity)

    fun inject(application: App)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): ApplicationComponent
    }
}