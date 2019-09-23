package com.example.weatherapp5.weatherdetail.currentWeather

import dagger.Module
import dagger.Provides

@Module
class CurrentWeatherModule {

    @Provides
    fun provideCurrentWeatherPresenter(model: CurrentWeatherMVP.Model): CurrentWeatherMVP.Presenter {
        return CurrentWeatherPresenter(model)
    }

    @Provides
    fun provideCurrentWeatherModel(): CurrentWeatherMVP.Model {
        return CurrentWeatherModel()
    }
}