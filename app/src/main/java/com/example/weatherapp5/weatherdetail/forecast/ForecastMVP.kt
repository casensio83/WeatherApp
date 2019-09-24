package com.example.weatherapp5.weatherdetail.forecast

import com.example.weatherapp5.weatherdetail.WeatherEntity
import retrofit2.Call

interface ForecastMVP {

    interface View {
        fun displayForecastData(weatherEntity: WeatherEntity)
    }

    interface Presenter {
        fun setView(view: View)
        fun getWeatherEntity(city: String)
    }

    interface Model {
        fun getForecastCall(city: String): Call<Any>
    }
}