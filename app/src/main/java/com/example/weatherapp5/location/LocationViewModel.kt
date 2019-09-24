package com.example.weatherapp5.location

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.weatherapp5.database.LocationEntity
import com.example.weatherapp5.database.LocationRepository

open class LocationViewModel constructor(application: Application) : AndroidViewModel(application) {

    private var repository: LocationRepository = LocationRepository(application)
    private var locations: LiveData<List<LocationEntity>>

    init {
        locations = repository.getLocations()
    }

    fun getLocations(): LiveData<List<LocationEntity>> = locations

    fun insertLocation(locationEntity: LocationEntity) = repository.insert(locationEntity)

}