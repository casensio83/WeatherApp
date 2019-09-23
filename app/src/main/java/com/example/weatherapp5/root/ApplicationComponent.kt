package com.example.weatherapp.root

import com.example.weatherapp5.weatherdetail.WeatherDetailsActivity
import com.example.weatherapp5.weatherdetail.entity.currentweather.CurrentWeatherModule
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