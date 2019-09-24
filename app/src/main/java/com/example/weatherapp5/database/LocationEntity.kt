package com.example.weatherapp5.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "location_table")
class LocationEntity(
    @PrimaryKey @ColumnInfo(name = "city") val city: String,
    @ColumnInfo(name = "country") val country: String
)