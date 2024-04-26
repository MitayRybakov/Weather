package com.example.weather.presentation.ui.mainScreen

import com.example.weather.domain.model.City

data class MainState(
    val city: City,
    val temperature:Int,
    val cities: List<City>
)