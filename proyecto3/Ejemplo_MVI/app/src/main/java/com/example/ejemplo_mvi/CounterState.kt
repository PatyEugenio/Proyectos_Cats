package com.example.ejemplo_mvi


data class CounterState(val count: Int = 0)

sealed class CounterEvent {
    object Increment : CounterEvent()
    object Decrement : CounterEvent()
}
