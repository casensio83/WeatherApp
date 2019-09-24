package com.example.weatherapp5.weatherdetail.currentWeather.presentation

import android.util.Log
import com.example.weatherapp5.weatherdetail.WeatherEntity
import com.example.weatherapp5.weatherdetail.currentWeather.CurrentWeatherMVP
import com.example.weatherapp5.weatherdetail.currentWeather.domain.entity.WeatherResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CurrentWeatherPresenter constructor(private var model: CurrentWeatherMVP.Model) :
    CurrentWeatherMVP.Presenter {

    private var view: CurrentWeatherMVP.View? = null
    private var weatherEntity: WeatherEntity? = null

    override fun setView(view: CurrentWeatherMVP.View) {
        this.view = view
    }

    override fun getWeatherEntity(city: String) {
        val currentWeatherCall = model.getCurrentWeatherCall(city)

        currentWeatherCall.enqueue(object : Callback<WeatherResult> {

            override fun onResponse(call: Call<WeatherResult>, response: Response<WeatherResult>) {
                weatherEntity = getWeatherEntity(response)
                if (view != null) {
                    view!!.displayCurrentWeatherData(weatherEntity!!)
                }
            }

            override fun onFailure(call: Call<WeatherResult>, t: Throwable) {
                Log.e(
                    CurrentWeatherPresenter::class.java.canonicalName,
                    "An error ocurred when trying to retrieve current weather data: $t"
                )
            }
        })
    }

    private fun getWeatherEntity(response: Response<WeatherResult>): WeatherEntity? {
        val body = response.body()

        if (body != null) {
            val weather = body.weather?.get(0)
            val temperature = body.main?.temp
            val date = body.dt
            val icon = weather?.icon
            val description = weather?.description
            val country = body.sys?.country
            val city = body.name
            return WeatherEntity(
                city,
                country,
                date,
                temperature,
                icon,
                description
            )
        }

        return null
    }
}