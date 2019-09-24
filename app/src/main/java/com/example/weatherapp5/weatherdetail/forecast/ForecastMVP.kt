package com.example.weatherapp5.weatherdetail.forecast

import com.example.weatherapp5.weatherdetail.forecast.domain.entity.ForecastResult
import com.example.weatherapp5.weatherdetail.forecast.domain.entity.ForecastObject
import retrofit2.Call

interface ForecastMVP {

    interface View {
        fun displayForecastData(weatherEntities: List<ForecastObject>)
    }

    interface Presenter {
        fun setView(view: View)
        fun getWeatherEntities(city: String)
    }

    interface Model {
        fun getForecastCall(city: String): Call<ForecastResult>
    }
}