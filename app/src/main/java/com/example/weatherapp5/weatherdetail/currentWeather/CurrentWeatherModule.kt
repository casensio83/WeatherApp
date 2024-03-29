package com.example.weatherapp5.weatherdetail.currentWeather

import com.example.weatherapp5.http.WeatherAPIService
import com.example.weatherapp5.weatherdetail.currentWeather.data.CurrentWeatherRepositoryImpl
import com.example.weatherapp5.weatherdetail.currentWeather.domain.CurrentWeatherModel
import com.example.weatherapp5.weatherdetail.currentWeather.domain.CurrentWeatherRepository
import com.example.weatherapp5.weatherdetail.currentWeather.presentation.CurrentWeatherPresenter
import dagger.Module
import dagger.Provides

@Module
class CurrentWeatherModule {

    @Provides
    fun provideCurrentWeatherPresenter(model: CurrentWeatherMVP.Model): CurrentWeatherMVP.Presenter {
        return CurrentWeatherPresenter(model)
    }

    @Provides
    fun provideCurrentWeatherModel(repository: CurrentWeatherRepository): CurrentWeatherMVP.Model {
        return CurrentWeatherModel(repository)
    }

    @Provides
    fun provideCurrentWeatherRepository(weatherAPIService: WeatherAPIService): CurrentWeatherRepository {
        return CurrentWeatherRepositoryImpl(weatherAPIService)
    }
}