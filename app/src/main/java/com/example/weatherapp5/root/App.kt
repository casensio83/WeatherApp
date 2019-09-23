package com.example.weatherapp.root

import android.app.Application
import com.example.weatherapp5.weatherdetail.currentWeather.entity.CurrentWeatherModule

class App: Application() {

    private lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerApplicationComponent.builder()
            .currentWeatherModule(CurrentWeatherModule())
            .build()
    }

    fun getComponent(): ApplicationComponent {
        return this.component
    }
}