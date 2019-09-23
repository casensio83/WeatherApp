package com.example.weatherapp.root

import com.example.weatherapp5.weatherdetail.currentWeather.WeatherDetailsActivity
import com.example.weatherapp5.weatherdetail.currentWeather.entity.CurrentWeatherModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = arrayOf(
        ApplicationModule::class,
        CurrentWeatherModule::class
    )
)
interface ApplicationComponent {

    fun inject(weatherDetailsActivity: WeatherDetailsActivity)
}