package com.example.weatherapp5.weatherdetail.forecast.presentation

import android.util.Log
import com.example.weatherapp5.weatherdetail.WeatherEntity
import com.example.weatherapp5.weatherdetail.forecast.ForecastMVP
import com.example.weatherapp5.weatherdetail.forecast.domain.ForecastModel
import com.example.weatherapp5.weatherdetail.forecast.domain.entity.ForecastResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ForecastPresenter(private var model: ForecastModel) :
    ForecastMVP.Presenter {

    private var view: ForecastMVP.View? = null
    private var weatherEntity: WeatherEntity? = null

    override fun setView(view: ForecastMVP.View) {
        this.view = view
    }

    override fun getWeatherEntity(city: String) {
        val forecastCall = model.getForecastCall(city)

        forecastCall.enqueue(object : Callback<ForecastResult> {

            override fun onResponse(call: Call<ForecastResult>, response: Response<ForecastResult>) {
                weatherEntity = getWeatherEntity(response)

                if (view != null) {
                    view!!.displayForecastData(weatherEntity!!)
                }
            }

            override fun onFailure(call: Call<ForecastResult>, t: Throwable) {
                Log.e(
                    ForecastPresenter::class.java.canonicalName,
                    "An error occurred when trying to retrieve forecast data: $t"
                )
            }
        })
    }

    private fun getWeatherEntity(response: Response<ForecastResult>): WeatherEntity? {
        val body = response.body()

        if (body != null) {
//            val weather = body.list?.weather
//            val temperature = body.list?.main?.temp
//            val date = body.list?.dt_text
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