package com.example.weatherapp.root

import com.example.weatherapp5.weatherdetail.WeatherDetailsActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = arrayOf(
        ApplicationModule::class
    )
)
interface ApplicationComponent {

    fun inject(weatherDetailsActivity: WeatherDetailsActivity)
}