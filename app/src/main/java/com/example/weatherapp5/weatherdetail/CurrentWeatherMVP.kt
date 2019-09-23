package com.example.weatherapp5.weatherdetail

import com.example.weatherapp5.http.WeatherAPIService
import com.example.weatherapp5.weatherdetail.entity.WeatherEntity

interface CurrentWeatherMVP {

    interface View {
        fun displayCurrentWeatherData(weatherEntity: WeatherEntity)
    }

    interface Presenter {
        fun setView(view: View)
        fun getWeatherEntity(city: String, weatherAPIService: WeatherAPIService)

        fun displayWeatherEntity(weatherEntity: WeatherEntity)
    }

    interface Model {

    }
}