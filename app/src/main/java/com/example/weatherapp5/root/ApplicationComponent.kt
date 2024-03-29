package com.example.weatherapp5.root

import com.example.weatherapp5.weatherdetail.WeatherDetailsActivity
import com.example.weatherapp5.weatherdetail.currentWeather.CurrentWeatherModule
import com.example.weatherapp5.weatherdetail.currentWeather.domain.entity.WeatherApiServiceModule
import com.example.weatherapp5.weatherdetail.forecast.ForecastModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        WeatherApiServiceModule::class,
        CurrentWeatherModule::class,
        ForecastModule::class
    ]
)
interface ApplicationComponent {

    fun inject(weatherDetailsActivity: WeatherDetailsActivity)
}