package com.example.weather.domain.model

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface YandexApi {
    @GET("v2/forecast")
    suspend fun getWeather(
        @Header("X-Yandex-API-Key") token: String,
        @Query("lat") lat: String,
        @Query("lon") lon: String
    ): Weather
}