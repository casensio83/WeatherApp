package com.example.weatherapp5.weatherdetail.currentWeather

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherapp.root.App
import com.example.weatherapp4.home.LocationAdapter
import com.example.weatherapp5.R
import com.example.weatherapp5.http.WeatherAPIService
import com.example.weatherapp5.weatherdetail.WeatherEntity
import kotlinx.android.synthetic.main.activity_weather_details.*
import javax.inject.Inject

class WeatherDetailsActivity : AppCompatActivity(), CurrentWeatherMVP.View {

    @Inject
    lateinit var weatherAPI: WeatherAPIService

    @Inject
    lateinit var presenter: CurrentWeatherMVP.Presenter

    private lateinit var lookForCity: String
    private lateinit var lookForCountry: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_details)

        (application as App).getComponent().inject(this)

        lookForCity = intent.getStringExtra(LocationAdapter.EXTRA_CITY_DETAILS)
        lookForCountry = intent.getStringExtra(LocationAdapter.EXTRA_COUNTRY_DETAILS)

    }

    override fun onResume() {
        super.onResume()
        presenter.setView(this)
        presenter.getWeatherEntity(lookForCity, weatherAPI)
    }

    override fun displayCurrentWeatherData(weatherEntity: WeatherEntity) {
        tv_current_temperature.text = weatherEntity.temperature.toString()
        tv_current_city.text = weatherEntity.city
        tv_current_country.text = weatherEntity.country
        tv_current_description.text = weatherEntity.description
    }

}
