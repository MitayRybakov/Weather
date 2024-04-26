package com.example.weather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.weather.domain.model.City
import com.example.weather.presentation.ui.mainScreen.MainViewModel
import com.example.weather.presentation.ui.mainScreen.compose.MainScreen
import com.example.weather.presentation.ui.theme.WeatherTheme
import dagger.hilt.android.AndroidEntryPoint
// вот тоже вопрос тут куда мне запихать мой ключ , если в стрнгу то как же опять мне вытаскивать их не в компоусе
const val key = "f7387e17-8855-4043-b3ea-c78b407faebd"


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherTheme {
                MainScreen(viewModel)
            }
        }
    }
}