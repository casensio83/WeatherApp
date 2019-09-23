package com.example.weatherapp5.weatherdetail.entity

data class WeatherEntity(
    val city: String,
    val country: String,
    val date: Int?,
    val temperature: Double?,
    val icon: String?,
    val description: String?
)