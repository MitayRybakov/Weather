package com.example.weather.domain.useCase

import com.example.weather.domain.model.City
import com.example.weather.domain.model.YandexApi
import com.example.weather.key
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class GetCityWeatherUseCase @Inject constructor(
) {  //я пока не понял куда мне вот это запихать я решил пока что сюда, подскажите пожажуста
    private val api = Retrofit.Builder()
        .baseUrl("https://api.weather.yandex.ru")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(YandexApi::class.java)

    suspend operator fun invoke(city: City): Int {
        val weather = api.getWeather(token = key, city.lat, city.lon)
        return weather.fact.temp
    }
}