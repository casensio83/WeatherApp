package com.example.weatherapp5.http

import com.example.weatherapp5.weatherdetail.currentWeather.domain.entity.WeatherResult
import com.example.weatherapp5.weatherdetail.forecast.domain.entity.ForecastResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPIService {

    @GET("weather")
    fun getCurrentWeather(@Query("appid") appId: String, @Query("q") city: String): Call<WeatherResult>

    @GET("forecast")
    fun getForecastWeather(@Query("appid") appId: String, @Query("q") city: String): Call<ForecastResult>

}