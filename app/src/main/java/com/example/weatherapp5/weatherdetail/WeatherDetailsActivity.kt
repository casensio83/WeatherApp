package com.example.weatherapp5.weatherdetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.weatherapp5.R
import com.example.weatherapp5.location.presentation.LocationAdapter
import com.example.weatherapp5.root.App
import com.example.weatherapp5.weatherdetail.currentWeather.CurrentWeatherMVP
import com.example.weatherapp5.weatherdetail.forecast.ForecastMVP
import com.example.weatherapp5.weatherdetail.forecast.domain.entity.ForecastObject
import com.example.weatherapp5.weatherdetail.forecast.presentation.ForecastAdapter
import kotlinx.android.synthetic.main.activity_weather_details.*
import javax.inject.Inject

const val ICON_ENDPOINT = "http://openweathermap.org/img/wn/"
const val ICON_FORMAT = "@2x.png"

class WeatherDetailsActivity : AppCompatActivity(),
    CurrentWeatherMVP.View, ForecastMVP.View {

    @Inject
    lateinit var presenter: CurrentWeatherMVP.Presenter

    @Inject
    lateinit var forecastPresenter: ForecastMVP.Presenter

    private lateinit var lookForCity: String
    private lateinit var lookForCountry: String
    private lateinit var adapter: ForecastAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_details)

        (application as App).getComponent().inject(this)

        adapter = ForecastAdapter(this)
        recyclerview_forecast.adapter = adapter
        recyclerview_forecast.layoutManager = LinearLayoutManager(this)

        lookForCity = intent.getStringExtra(LocationAdapter.EXTRA_CITY_DETAILS)
        lookForCountry = intent.getStringExtra(LocationAdapter.EXTRA_COUNTRY_DETAILS)

    }

    override fun onResume() {
        super.onResume()
        presenter.setView(this)
        forecastPresenter.setView(this)
        presenter.getWeatherEntity(lookForCity)
        forecastPresenter.getWeatherEntities(lookForCity)
    }

    override fun displayCurrentWeatherData(weatherEntity: WeatherEntity) {
        tv_current_temperature.text = weatherEntity.temperature.toString() + " F"
        tv_current_city.text = weatherEntity.city
        tv_current_country.text = "(" + weatherEntity.country + ")"
        tv_current_description.text = weatherEntity.description
        tv_current_date.text = weatherEntity.date

        Glide.with(this)
            .load(ICON_ENDPOINT + weatherEntity.icon + ICON_FORMAT)
            .into(iv_current_icon)
    }

    override fun displayForecastData(weatherEntities: List<ForecastObject>) {
        adapter.setWeatherEntities(weatherEntities)
    }

}
