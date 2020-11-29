package com.leonardolsantos.myweather.service

import android.telecom.Call
import com.leonardolsantos.myweather.model.City
import com.leonardolsantos.myweather.model.Root
import retrofit2.http.Query
import retrofit2.http.GET
import retrofit2.http.Path

interface OpenWeatherService {

    @GET("weather")
    fun getCityWeather(
        @Query("q") cityName: String,
        @Query("APPID") appId: String = "9a1774a535605ebadf5c6d2bc2425f40"
    ) : retrofit2.Call <City>

    @GET("find")
    fun findTemperatures(@Query("q") cityName: String,
                         @Query("units") units: String = "metric",
                         @Query("APPID") appid: String = "9a1774a535605ebadf5c6d2bc2425f40"
    ): retrofit2.Call<Root>

}
