package com.example.cats.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cats.domain.model.CatFactStates
import com.example.cats.domain.model.Fact
import com.example.cats.domain.usecase.GetCatRandomFactUseCase
import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlinx.coroutines.flow.*

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCatRandomFactUseCase: GetCatRandomFactUseCase
): ViewModel() {
    private val _uiState = MutableStateFlow<CatFactStates>(CatFactStates.Init)
    val uiState: StateFlow <CatFactStates> = _uiState

init{
    getCatFact()
}
    fun getCatFact() = viewModelScope.launch {
        val catFactStates = getCatRandomFactUseCase().first()
        withContext(Dispatchers.IO) {
            when (catFactStates) {
                is CatFactStates.Init->notifyInitState()
                is CatFactStates.Loading -> notifyLoadingState()
                is CatFactStates.CatFactData -> notifyCatFactState(catFactStates.fact)
                is CatFactStates.Error -> notifyErrorState(catFactStates.error)
            }
        }
    }

    private fun notifyInitState() {
        _uiState.value=CatFactStates.Init
    }

    private fun notifyLoadingState() {
        _uiState.value=CatFactStates.Loading
    }


    private fun notifyCatFactState(fact: Fact) {
        _uiState.value=CatFactStates.CatFactData(fact)
    }

    private fun notifyErrorState(error: Throwable) {
        _uiState.value=CatFactStates.Error(error)
    }

}