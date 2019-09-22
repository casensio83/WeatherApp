package com.example.weatherapp.root

import android.app.Application

class App: Application() {

    private lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerApplicationComponent.builder()
            .build()
    }

    fun getComponent(): ApplicationComponent {
        return this.component
    }
}