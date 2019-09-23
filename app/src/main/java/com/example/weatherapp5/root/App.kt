package com.example.weatherapp.root

import android.app.Application
import com.example.weatherapp5.weatherdetail.currentWeather.CurrentWeatherModule
import com.example.weatherapp5.weatherdetail.currentWeather.entity.WeatherApiServiceModule

class App: Application() {

    private lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerApplicationComponent.builder()
            .currentWeatherModule(CurrentWeatherModule())
            .weatherApiServiceModule(WeatherApiServiceModule())
            .build()
    }

    fun getComponent(): ApplicationComponent {
        return this.component
    }
}