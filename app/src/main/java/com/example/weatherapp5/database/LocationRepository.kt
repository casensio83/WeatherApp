package com.example.weatherapp4.database

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData

class LocationRepository(application: Application) {

    private lateinit var locationDao: LocationDao
    private lateinit var locations: LiveData<List<LocationEntity>>

    init {
        val db = LocationRoomDatabase.getDatabase(application)
        if (db != null) {
            locationDao = db.locationDao()
            locations = locationDao.getLocations()
        }

    }

    fun getLocations(): LiveData<List<LocationEntity>> {
        return locations
    }

    fun insert(locationEntity: LocationEntity) {
        insertAsyncTask(locationDao).execute(locationEntity)
    }

    private class insertAsyncTask internal constructor(private val mAsyncTaskDao: LocationDao) :
        AsyncTask<LocationEntity, Void, Void>() {

        override fun doInBackground(vararg params: LocationEntity): Void? {
            mAsyncTaskDao.insert(params[0])
            return null
        }
    }
}