package com.example.weatherapp5.weatherdetail.forecast.domain.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Coord {

    @SerializedName("lat")
    @Expose
    var lat: Double? = null
    @SerializedName("lon")
    @Expose
    var lon: Double? = null

}
