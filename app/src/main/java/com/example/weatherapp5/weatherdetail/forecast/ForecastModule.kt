package com.example.weatherapp5.weatherdetail.forecast

import com.example.weatherapp5.http.WeatherAPIService
import com.example.weatherapp5.weatherdetail.forecast.data.ForecastRepositoryImpl
import com.example.weatherapp5.weatherdetail.forecast.domain.ForecastModel
import com.example.weatherapp5.weatherdetail.forecast.domain.ForecastRepository
import com.example.weatherapp5.weatherdetail.forecast.presentation.ForecastPresenter
import dagger.Module
import dagger.Provides

@Module
class ForecastModule {

    @Provides
    fun provideForecastPresenter(model: ForecastMVP.Model): ForecastMVP.Presenter {
        return ForecastPresenter(model as ForecastModel)
    }

    @Provides
    fun provideForecastModel(repository: ForecastRepository): ForecastMVP.Model {
        return ForecastModel(repository)
    }

    @Provides
    fun provideForecastRepository(weatherAPIService: WeatherAPIService): ForecastRepository {
        return ForecastRepositoryImpl(weatherAPIService)
    }
}