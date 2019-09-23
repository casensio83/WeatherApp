package com.example.weatherapp5.weatherdetail

import com.example.weatherapp5.http.WeatherAPIService
import com.example.weatherapp5.weatherdetail.entity.WeatherEntity
import com.example.weatherapp5.weatherdetail.entity.currentweather.WeatherResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

const val APP_ID = "c8342d806e1d8e4aca0b12be0318fe5d"

class CurrentWeatherPresenter : CurrentWeatherMVP.Presenter {

    private var view: CurrentWeatherMVP.View? = null
    private var weatherEntity: WeatherEntity? = null

    override fun setView(view: CurrentWeatherMVP.View) {
        this.view = view
    }

    override fun getWeatherEntity(city: String, weatherAPIService: WeatherAPIService) {
        val call = weatherAPIService.getWeather(APP_ID, city)

        call.enqueue(object : Callback<WeatherResult> {

            override fun onResponse(call: Call<WeatherResult>, response: Response<WeatherResult>) {
                weatherEntity = getWeatherentity(response)
                if (view != null) {
                    view!!.displayCurrentWeatherData(weatherEntity!!)
                }
            }

            override fun onFailure(call: Call<WeatherResult>, t: Throwable) {

            }
        })
    }

    private fun getWeatherentity(response: Response<WeatherResult>): WeatherEntity? {
        val body = response.body()

        if (body != null) {
            val temperature = body.main?.temp
            val date = body.dt
            val icon = body.weather?.get(0)?.icon
            val description = body.weather?.get(0)?.description
            val country = body.sys.country
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

    override fun displayWeatherEntity(weatherEntity: WeatherEntity) {

    }
}