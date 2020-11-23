package com.leonardolsantos.myweather.model
data class City(
    val id:Long,
    val name:String,
)


//import com.google.gson.annotations.SerializedName
//
//data class City(
//    val id:Long,
//    val name:String,
//    val weather: List<Weather>,
//    val wind: Wind,
//    val main: Main
//)
//
//
//data class Main (
//    val temp: Double,
//
//    @SerializedName("feels_like")
//    val feelsLike: Double,
//
//    @SerializedName("temp_min")
//    val tempMin: Double,
//
//    @SerializedName("temp_max")
//    val tempMax: Double,
//
//    val pressure: Long,
//    val humidity: Long
//)
//
//
//
//data class Weather (
//    val id: Long,
//    val main: String,
//    val description: String,
//    val icon: String
//)
//
//data class Wind (
//    val speed: Double,
//    val deg: Long
//)