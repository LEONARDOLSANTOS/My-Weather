package com.leonardolsantos.myweather.service

import android.telecom.Call
import com.leonardolsantos.myweather.model.City
import retrofit2.http.Query
import retrofit2.http.GET

interface OpenWeatherService {

    @GET("weather")
    fun getCityWeather(
        @Query("q") cityName: String,
        @Query("APPID") appId: String
    ) : retrofit2.Call <City>
}
