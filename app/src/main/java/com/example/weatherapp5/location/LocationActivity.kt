package com.example.weatherapp5.location

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp5.R
import com.example.weatherapp5.database.LocationEntity
import kotlinx.android.synthetic.main.activity_location.*
import kotlinx.android.synthetic.main.content_location.*

const val NEW_LOCATION_REQUEST_CODE = 100

class LocationActivity : AppCompatActivity() {

    private lateinit var locationViewModel: LocationViewModel
    private lateinit var adapter: LocationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)

        adapter = LocationAdapter(this)
        recyclerview_locations.adapter = adapter
        recyclerview_locations.layoutManager = LinearLayoutManager(this)

        locationViewModel = ViewModelProviders.of(this).get(LocationViewModel::class.java)
        locationViewModel.getLocations().observe(this,
            Observer { locations -> adapter.setLocations(locations as List<LocationEntity>) })

        fab.setOnClickListener {
            val intent = Intent(this, NewLocationActivity::class.java)
            startActivityForResult(intent, NEW_LOCATION_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == NEW_LOCATION_REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null) {
            val city = data.getStringExtra(NewLocationActivity.EXTRA_NEW_LOCATION_CITY) ?: ""
            val country = data.getStringExtra(NewLocationActivity.EXTRA_NEW_LOCATION_COUNTRY) ?: ""
            val locationEntity = LocationEntity(city, country)
            locationViewModel.insertLocation(locationEntity)
        }
    }

    override fun onBackPressed() {
        finishAndRemoveTask()
    }
}
