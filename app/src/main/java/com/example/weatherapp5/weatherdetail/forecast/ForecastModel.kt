package com.example.weatherapp5.weatherdetail.forecast

import com.example.weatherapp5.http.WeatherAPIService
import retrofit2.Call

class ForecastModel(val repository: ForecastRepository) : ForecastMVP.Model {

    override fun getForecastCall(city: String, weatherAPIService: WeatherAPIService): Call<Any> {
        return repository.getForecastWeather(APP_ID, city)
    }
}