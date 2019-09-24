package com.example.weatherapp5.weatherdetail.currentWeather.domain

import com.example.weatherapp5.weatherdetail.currentWeather.CurrentWeatherMVP
import com.example.weatherapp5.weatherdetail.currentWeather.data.APP_ID
import com.example.weatherapp5.weatherdetail.currentWeather.domain.entity.WeatherResult
import retrofit2.Call


class CurrentWeatherModel(private val repository: CurrentWeatherRepository) :
    CurrentWeatherMVP.Model {

    override fun getCurrentWeatherCall(city: String): Call<WeatherResult> {
        return repository.getCurrentWeather(APP_ID, city)
    }

}