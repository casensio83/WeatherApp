package com.example.weatherapp5.weatherdetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weatherapp.root.App
import com.example.weatherapp4.home.LocationAdapter
import com.example.weatherapp5.R

class WeatherDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_details)

        (application as App).getComponent().inject(this)

        val lookForCity = intent.getStringExtra(LocationAdapter.EXTRA_CITY_DETAILS)
        val lookForCountry = intent.getStringExtra(LocationAdapter.EXTRA_COUNTRY_DETAILS)


    }
}
