package com.leonardolsantos.myweather.manager

import com.leonardolsantos.myweather.service.OpenWeatherService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class OpenWeatherManager {
    //    http://api.openweathermap.org/data/2.5/weather?q=recife&APPID=9a1774a535605ebadf5c6d2bc2425f40

    private val instance = Retrofit.Builder()
        .baseUrl("http://api.openweathermap.org/data/2.5/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getOpenWeatherService() = instance.create(OpenWeatherService::class.java)
}
