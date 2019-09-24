package com.example.weatherapp5.weatherdetail.currentWeather.data

import com.example.weatherapp5.http.WeatherAPIService
import com.example.weatherapp5.weatherdetail.currentWeather.domain.CurrentWeatherRepository
import com.example.weatherapp5.weatherdetail.currentWeather.domain.entity.WeatherResult
import retrofit2.Call

const val APP_ID = "c8342d806e1d8e4aca0b12be0318fe5d"

class CurrentWeatherRepositoryImpl(private val weatherApiService: WeatherAPIService) :
    CurrentWeatherRepository {

    override fun getCurrentWeather(appId: String, city: String): Call<WeatherResult> {
        return weatherApiService.getCurrentWeather(APP_ID, city)
    }
}