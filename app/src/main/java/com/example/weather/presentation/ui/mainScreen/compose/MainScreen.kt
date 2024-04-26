package com.example.weather.presentation.ui.mainScreen.compose

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.R
import com.example.weather.presentation.ui.mainScreen.MainState
import com.example.weather.presentation.ui.mainScreen.MainViewModel

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun MainScreen(viewModel: MainViewModel) {

    val state by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            Alignment.Center
        ) {
            Text(
                text = "${state.city.fullName} = ${state.temperature}",
                fontSize = 30.sp,
            )
        }

        Text(
            text = stringResource(R.string.choice),
            fontSize = 30.sp,
        )

        Cities(state, viewModel)
    }
}

@Composable
fun Cities(state: MainState, viewModel: MainViewModel) {
    LazyColumn {
        items(state.cities.size) { index ->
            Text(
                text = state.cities[index].fullName,
                fontSize = 30.sp,
                modifier = Modifier
                    .selectable(
                        selected = true,
                        enabled = true,
                        role = null,
                        onClick = {
                            viewModel.onCityChange(state.cities[index])
                            viewModel.tempInCity()
                        }
                    )
            )
        }
    }
}