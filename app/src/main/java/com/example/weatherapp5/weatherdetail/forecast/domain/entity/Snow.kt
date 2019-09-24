package com.example.weatherapp5.weatherdetail.forecast.domain.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Snow {

    @SerializedName("3h")
    @Expose
    var threeH: Double? = null

}
