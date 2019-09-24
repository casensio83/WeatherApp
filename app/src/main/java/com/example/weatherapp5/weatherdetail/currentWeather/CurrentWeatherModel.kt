package com.example.weatherapp5.weatherdetail.currentWeather

import com.example.weatherapp5.http.WeatherAPIService
import com.example.weatherapp5.weatherdetail.currentWeather.entity.WeatherResult
import retrofit2.Call


class CurrentWeatherModel (private val repository: CurrentWeatherRepository): CurrentWeatherMVP.Model {

    override fun getCurrentWeatherCall(city: String, weatherAPIService: WeatherAPIService): Call<WeatherResult> {
        return repository.getCurrentWeather(APP_ID, city)
    }

}