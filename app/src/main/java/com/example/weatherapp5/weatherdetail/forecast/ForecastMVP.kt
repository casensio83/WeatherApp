package com.example.weatherapp5.weatherdetail.forecast

import com.example.weatherapp5.http.WeatherAPIService
import com.example.weatherapp5.weatherdetail.WeatherEntity
import retrofit2.Call

interface ForecastMVP {

    interface View {
        fun displayForecastData(weatherEntity: WeatherEntity)
    }

    interface Presenter {
        fun setView(view: View)
        fun getWeatherEntity(city: String, weatherAPIService: WeatherAPIService)
    }

    interface Model {
        fun getForecastCall(city: String, weatherAPIService: WeatherAPIService) : Call<Any>
    }
}