package com.example.weatherapp5.weatherdetail.forecast

import com.example.weatherapp5.http.WeatherAPIService
import com.example.weatherapp5.weatherdetail.WeatherEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ForecastPresenter(model: ForecastModel) : ForecastMVP.Presenter {

    private var view: ForecastMVP.View? = null
    private var weatherEntity: WeatherEntity? = null
    private var model: ForecastMVP.Model

    init {
        this.model = model
    }

    override fun setView(view: ForecastMVP.View) {
        this.view = view
    }

    override fun getWeatherEntity(city: String, weatherAPIService: WeatherAPIService) {
        val forecastCall = model.getForecastCall(city, weatherAPIService)

        forecastCall.enqueue(object : Callback<Any> {

            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                weatherEntity = getWeatherEntity(response)

                if (view != null) {
                    view!!.displayForecastData(weatherEntity!!)
                }
            }

            override fun onFailure(call: Call<Any>, t: Throwable) {
                val saludo = ""
            }
        })
    }

    private fun getWeatherEntity(response: Response<Any>): WeatherEntity? {
        val body = response.body()

        if (body != null) {
//            val weather = body.list?.weather
//            val temperature = body.list?.main?.temp
//            val date = body.list?.dt
//            val icon = weather?.icon
//            val description = weather?.description
//            val country = body.city?.country
//            val city = body.city?.name
//            return WeatherEntity(
//                city,
//                country,
//                date,
//                temperature,
//                icon,
//                description
//            )
        }

        return null
    }
}