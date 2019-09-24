package com.example.weatherapp5.weatherdetail.forecast.presentation

import android.util.Log
import com.example.weatherapp5.weatherdetail.forecast.ForecastMVP
import com.example.weatherapp5.weatherdetail.forecast.domain.ForecastModel
import com.example.weatherapp5.weatherdetail.forecast.domain.entity.ForecastResult
import com.example.weatherapp5.weatherdetail.forecast.domain.entity.ForecastObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ForecastPresenter(private var model: ForecastModel) :
    ForecastMVP.Presenter {

    private var view: ForecastMVP.View? = null
    private var weatherEntities: List<ForecastObject>? = null

    override fun setView(view: ForecastMVP.View) {
        this.view = view
    }

    override fun getWeatherEntities(city: String) {
        val forecastCall = model.getForecastCall(city)

        forecastCall.enqueue(object : Callback<ForecastResult> {

            override fun onResponse(call: Call<ForecastResult>, response: Response<ForecastResult>) {
                weatherEntities = getWeatherEntities(response)

                if (view != null) {
                    view!!.displayForecastData(weatherEntities!!)
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

    private fun getWeatherEntities(response: Response<ForecastResult>): List<ForecastObject>? {
        val body = response.body()

        if (body != null) {
            return body.list
        }

        return null
    }
}