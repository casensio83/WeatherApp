package com.example.weatherapp4.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "location_table")
class LocationEntity(
    @PrimaryKey @ColumnInfo(name = "city") val city: String,
    @ColumnInfo(name = "country") val country: String
)