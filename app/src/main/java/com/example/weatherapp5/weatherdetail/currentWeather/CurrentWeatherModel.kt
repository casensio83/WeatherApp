package com.example.weatherapp5.weatherdetail.currentWeather

import com.example.weatherapp5.http.WeatherAPIService
import com.example.weatherapp5.weatherdetail.currentWeather.entity.WeatherResult
import retrofit2.Call

const val APP_ID = "c8342d806e1d8e4aca0b12be0318fe5d"

class CurrentWeatherModel: CurrentWeatherMVP.Model {

    override fun getCurrentWeatherCall(city: String, weatherAPIService: WeatherAPIService): Call<WeatherResult> {
        return weatherAPIService.getCurrentWeather(APP_ID, city)
    }

}