package com.example.weatherapp5.http

import com.example.weatherapp5.weatherdetail.currentWeather.entity.WeatherResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPIService {

    @GET("weather")
    fun getCurrentWeather(@Query("appid") appId: String, @Query("q") city: String): Call<WeatherResult>

}