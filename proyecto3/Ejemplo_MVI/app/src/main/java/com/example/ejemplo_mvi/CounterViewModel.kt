package com.example.ejemplo_mvi

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf


class CounterViewModel {
    private val _state = mutableStateOf(CounterState())

    val state: State<CounterState> = _state

    fun handleEvent(event: CounterEvent) {
        when (event) {
            is CounterEvent.Increment -> _state.value = _state.value.copy(count = _state.value.count + 1)
            is CounterEvent.Decrement -> _state.value = _state.value.copy(count = _state.value.count - 1)
        }
    }
}