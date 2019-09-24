package com.example.weatherapp5.root

import android.app.Application
import com.example.weatherapp5.weatherdetail.currentWeather.CurrentWeatherModule
import com.example.weatherapp5.weatherdetail.currentWeather.domain.entity.WeatherApiServiceModule
import com.example.weatherapp5.weatherdetail.forecast.ForecastModule

class App : Application() {

    private lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerApplicationComponent.builder()
            .currentWeatherModule(CurrentWeatherModule())
            .weatherApiServiceModule(WeatherApiServiceModule())
            .forecastModule(ForecastModule())
            .build()
    }

    fun getComponent(): ApplicationComponent {
        return this.component
    }
}