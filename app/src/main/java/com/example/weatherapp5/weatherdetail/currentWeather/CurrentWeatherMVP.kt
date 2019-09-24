package com.example.weatherapp5.weatherdetail.currentWeather

import com.example.weatherapp5.weatherdetail.WeatherEntity
import com.example.weatherapp5.weatherdetail.currentWeather.domain.entity.WeatherResult
import retrofit2.Call

interface CurrentWeatherMVP {

    interface View {
        fun displayCurrentWeatherData(weatherEntity: WeatherEntity)
    }

    interface Presenter {
        fun setView(view: View)
        fun getWeatherEntity(city: String)
    }

    interface Model {
        fun getCurrentWeatherCall(city: String): Call<WeatherResult>
    }
}