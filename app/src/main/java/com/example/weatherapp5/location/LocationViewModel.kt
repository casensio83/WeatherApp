package com.example.weatherapp4.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp4.database.LocationEntity
import com.example.weatherapp4.database.LocationRepository

open class LocationViewModel constructor(application: Application): AndroidViewModel(application), ViewModelProvider.Factory {

    private var repository: LocationRepository = LocationRepository(application)
    private var locations: LiveData<List<LocationEntity>>
    private val app = application

    init {
        locations = repository.getLocations()
    }

    fun getLocations(): LiveData<List<LocationEntity>> = locations

    fun insertLocation(locationEntity: LocationEntity) = repository.insert(locationEntity)

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LocationViewModel(this.app) as (T)
    }
}