package com.example.weatherapp5.weatherdetail.currentWeather

import com.example.weatherapp5.http.WeatherAPIService
import com.example.weatherapp5.weatherdetail.currentWeather.domain.entity.WeatherResult
import com.example.weatherapp5.weatherdetail.WeatherEntity
import retrofit2.Call

interface CurrentWeatherMVP {

    interface View {
        fun displayCurrentWeatherData(weatherEntity: WeatherEntity)
    }

    interface Presenter {
        fun setView(view: View)
        fun getWeatherEntity(city: String, weatherAPIService: WeatherAPIService)
    }

    interface Model {
        fun getCurrentWeatherCall(city: String, weatherAPIService: WeatherAPIService) : Call<WeatherResult>
    }
}