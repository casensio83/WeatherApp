package com.example.weatherapp4.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LocationDao {

    @Query("SELECT * from location_table ORDER BY city ASC")
    fun getLocations(): LiveData<List<LocationEntity>>

    @Insert
    fun insert(location: LocationEntity)

    @Query("DELETE FROM location_table")
    fun deleteAll()
}