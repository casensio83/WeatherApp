package com.example.weatherapp5.weatherdetail.forecast.domain.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ForecastResult {

    @SerializedName("cod")
    @Expose
    var cod: String? = null
    @SerializedName("message")
    @Expose
    var message: Double? = null
    @SerializedName("cnt")
    @Expose
    var cnt: Int? = null
    @SerializedName("list")
    @Expose
    var list: List? = null
    @SerializedName("city")
    @Expose
    var city: City? = null

}
