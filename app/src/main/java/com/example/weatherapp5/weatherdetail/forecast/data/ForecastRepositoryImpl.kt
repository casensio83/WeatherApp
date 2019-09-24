package com.example.weatherapp5.weatherdetail.forecast.data

import com.example.weatherapp5.http.WeatherAPIService
import com.example.weatherapp5.weatherdetail.forecast.domain.ForecastRepository
import retrofit2.Call

const val APP_ID = "c8342d806e1d8e4aca0b12be0318fe5d"

class ForecastRepositoryImpl(private val weatherApiService: WeatherAPIService):
    ForecastRepository {

    override fun getForecastWeather(appId: String, city: String): Call<Any> {
        return weatherApiService.getForecastWeather(APP_ID, city)
    }
}