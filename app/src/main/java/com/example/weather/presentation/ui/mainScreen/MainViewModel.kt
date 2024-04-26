package com.example.weather.presentation.ui.mainScreen

import androidx.lifecycle.ViewModel
import com.example.weather.domain.model.City
import com.example.weather.domain.useCase.GetCityWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCityWeatherUseCase: GetCityWeatherUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        MainState(
            city = City(lat = "0", lon = "0", fullName = ""),
            temperature = 0,
            cities = mutableListOf(
                //пока что решил просто хардкодом передать список городов , с координатами, потом переделаю
                City(lat = "56.20417786", lon = "95.70665741", fullName = "Канск"),
                City(lat = "43.11554337", lon = "131.885498", fullName = "Владивосток"),
                City(lat = "69.40576935", lon = "86.16499329", fullName = "Дудинка"),
                City(lat = "55.4507", lon = "37.3656", fullName = "Москва"),
                City(lat = "59.57", lon = "30.19", fullName = "Санкт-Петербург"),
            )
        )
    )
    val uiState: StateFlow<MainState> = _uiState.asStateFlow()

    fun tempInCity() {
        CoroutineScope(Dispatchers.IO).launch {
            _uiState.value = _uiState.value.copy(
                temperature = getCityWeatherUseCase(city =_uiState.value.city)
            )
        }
    }
    fun onCityChange(city:City){
        _uiState.value = _uiState.value.copy(
            city = city
        )
    }
}