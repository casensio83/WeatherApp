package com.example.weatherapp.root

import com.example.weatherapp5.weatherdetail.currentWeather.CurrentWeatherModule
import com.example.weatherapp5.weatherdetail.currentWeather.WeatherDetailsActivity
import com.example.weatherapp5.weatherdetail.currentWeather.entity.WeatherApiServiceModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = arrayOf(
        ApplicationModule::class,
        WeatherApiServiceModule::class,
        CurrentWeatherModule::class
    )
)
interface ApplicationComponent {

    fun inject(weatherDetailsActivity: WeatherDetailsActivity)
}