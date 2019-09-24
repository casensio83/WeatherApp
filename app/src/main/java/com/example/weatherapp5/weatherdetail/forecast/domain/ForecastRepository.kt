package com.example.weatherapp5.weatherdetail.forecast.domain

import com.example.weatherapp5.weatherdetail.forecast.domain.entity.ForecastResult
import retrofit2.Call

interface ForecastRepository {

    fun getForecastWeather(appId: String, city: String): Call<ForecastResult>
}