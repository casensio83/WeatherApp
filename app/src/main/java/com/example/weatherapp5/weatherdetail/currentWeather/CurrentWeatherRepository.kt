package com.example.weatherapp5.weatherdetail.currentWeather

import com.example.weatherapp5.weatherdetail.currentWeather.entity.WeatherResult
import retrofit2.Call

interface CurrentWeatherRepository {

    fun getCurrentWeather(appId: String, city: String): Call<WeatherResult>
}