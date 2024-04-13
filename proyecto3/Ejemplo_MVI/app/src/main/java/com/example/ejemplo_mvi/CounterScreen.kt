package com.example.ejemplo_mvi

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp



@Composable
fun CounterScreen(viewModel: CounterViewModel) {
    val state = viewModel.state.value

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Count: ${state.count}")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { viewModel.handleEvent(CounterEvent.Increment) }) {
            Text(text = "Increment")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { viewModel.handleEvent(CounterEvent.Decrement) }) {
            Text(text = "Decrement")
        }
    }
}



