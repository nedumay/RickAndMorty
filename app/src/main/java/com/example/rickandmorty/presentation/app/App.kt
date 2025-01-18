package com.example.rickandmorty.presentation.app

import android.app.Application
import com.example.rickandmorty.di.DaggerApplicationComponent

class App: Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }


    override fun onCreate() {
        component.inject(this)
        super.onCreate()
    }
}