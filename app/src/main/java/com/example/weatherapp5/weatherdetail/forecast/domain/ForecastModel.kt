package com.example.weatherapp5.weatherdetail.forecast.domain

import com.example.weatherapp5.weatherdetail.forecast.ForecastMVP
import com.example.weatherapp5.weatherdetail.forecast.data.APP_ID
import com.example.weatherapp5.weatherdetail.forecast.domain.entity.ForecastResult
import retrofit2.Call

class ForecastModel(private val repository: ForecastRepository) :
    ForecastMVP.Model {

    override fun getForecastCall(city: String): Call<ForecastResult> {
        return repository.getForecastWeather(APP_ID, city)
    }
}