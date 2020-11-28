package com.leonardolsantos.myweather.model

import com.google.gson.annotations.SerializedName

data class City(
    val id:Long,
    val name:String,
    val wind: Wind,
    val main: Main,
    val weather: List<Weather>
)
data class Wind (
    val speed: Double,
    val deg: Long
)
data class Main (
    val temp: Double,

    @SerializedName("feels_like")
    val feelsLike: Double,

    @SerializedName("temp_min")
    val tempMin: Double,

    @SerializedName("temp_max")
    val tempMax: Double,

    val pressure: Long,
    val humidity: Long
)

data class Weather (
    val id: Long,
    val main: String,
    val description: String,
    val icon: String
)


