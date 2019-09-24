package com.example.weatherapp5.weatherdetail.forecast.domain

import com.example.weatherapp5.http.WeatherAPIService
import com.example.weatherapp5.weatherdetail.forecast.data.APP_ID
import com.example.weatherapp5.weatherdetail.forecast.ForecastMVP
import retrofit2.Call

class ForecastModel(private val repository: ForecastRepository) :
    ForecastMVP.Model {

    override fun getForecastCall(city: String, weatherAPIService: WeatherAPIService): Call<Any> {
        return repository.getForecastWeather(APP_ID, city)
    }
}