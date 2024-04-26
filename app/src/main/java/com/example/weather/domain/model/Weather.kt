package com.example.weather.domain.model

data class Weather(
    val now: Int,
    val nowDt: String,
    val info: Info,
    val fact: Fact,
    val forecasts: List<Forecast>,
)

data class Forecast(
    val date: String,
    val dateTs: Int,
    val week: Int,
    val riseBegin: String,
    val sunrise: String,
    val sunset: String,
    val sunEnd: String,
    val moonCode: Int,
    val moonText: String,
    val parts: Parts,
    val night: WeatherTimeOfDay,
    val tempMin: Int,
    val tempMax: Int,
    val tempAvr: Int,
    val feelsLike: Float,
    val icon: String,
    val condition: String,
    val dayTime: String,
    val polar: Boolean,
    val windSpeed: Float,
    val windGust: Float,
    val windDir: String,
    val pressureMm: Float,
    val pressurePa: Float,
    val humidity: Float,
    val soilTemp: Float,
    val soilMoisture: Float,
    val precMm: Float,
    val precPeriod: Float,
    val precType: Int,
    val precStrength: Float,
    val freshSnowMm: Int,
    val cloudness: Float,
    val uvIndex: Int,
    val dayShort: TwelveHoursWeather,
    val temp: Int,
    val hours: List<HoursWeather>,
    val hour: String,
    val hourTs: Int,

    )

data class HoursWeather(
    val temp: Int,
    val feelsLike: Int,
    val icon: String,
    val condition: String,
    val windSpeed: Float,
    val windGust: Float,
    val windDir: String,
    val pressureMm: Float,
    val pressurePa: Float,
    val humidity: Float,
    val precMm: Float,
    val precPeriod: Float,
    val precType: Int,
    val precStrength: Float,
    val isThunder: Boolean,
    val cloudness: Float,
)

data class Parts(
    val night: WeatherTimeOfDay,
    val morning: WeatherTimeOfDay,
    val day: WeatherTimeOfDay,
    val evening: WeatherTimeOfDay,
    val dayShort: TwelveHoursWeather,
    val nightShorts: TwelveHoursWeather,
)

data class TwelveHoursWeather(
    val temp: Int,
    val tempMin: Int,
    val feelsLike: Int,
    val icon: String,
    val condition: String,
    val windSpeed: Float,
    val windGust: Float,
    val windDir: String,
    val pressureMm: Float,
    val pressurePa: Float,
    val humidity: Float,
    val precType: Int,
    val precStrength: Float,
    val cloudness: Float,
)


data class WeatherTimeOfDay(
    val tempMin: Int,
    val tempMax: Int,
    val tempAvr: Int,
    val feelsLike: Int,
    val icon: String,
    val condition: String,
    val dayTime: String,
    val polar: Boolean,
    val windSpeed: Float,
    val windGust: Float,
    val windDir: String,
    val pressureMm: Float,
    val pressurePa: Float,
    val humidity: Float,
    val precMm: Float,
    val precPeriod: Float,
    val precType: Int,
    val precStrength: Float,
    val cloudness: Float,
)

data class Fact(
    val temp: Int,
    val feelsLike: Int,
    val tempWater: Int,
    val icon: String,
    val condition: String,
    val windSpeed: Float,
    val windGust: Float,
    val windDir: String,
    val pressureMm: Float,
    val pressurePa: Float,
    val humidity: Float,
    val dayTime: String,
    val polar: Boolean,
    val season: String,
    val precType: Int,
    val precStrength: Float,
    val isThunder: Boolean,
    val cloudness: Float,
    val obsTime: Int,
    val phenomIcon: String,
    val phenomCondition: String,
)

data class Info(
    val lat: Double,
    val lon: Double,
    val tzInfo: TzInfo,
    val defPressureMm: Int,
    val defPressurePa: Int,
    val url: String
)

data class TzInfo(
    val offset: Int,
    val name: String,
    val abbr: String,
    val dst: Boolean
)