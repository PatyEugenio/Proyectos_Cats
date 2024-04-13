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
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCatRandomFactUseCase: GetCatRandomFactUseCase
): ViewModel() {
    private val mutableCatFact = MutableLiveData<CatFactStates>()
    val catFact: LiveData<CatFactStates>
        get() = mutableCatFact


    fun getCatFact() = viewModelScope.launch {
        val catFactStates = getCatRandomFactUseCase()
        withContext(Dispatchers.IO) {
            when (catFactStates) {
                is CatFactStates.Loading -> notifyLoadingState()
                is CatFactStates.CatFactData -> notifyCatFactState(catFactStates.fact)
                is CatFactStates.Error -> notifyErrorState(catFactStates.error)
            }
        }
    }

    private fun notifyLoadingState() {
        mutableCatFact.postValue(CatFactStates.Loading)
    }

    private fun notifyCatFactState(fact: Fact) {
        mutableCatFact.postValue(CatFactStates.CatFactData(fact))
    }

    private fun notifyErrorState(error: Throwable) {
        mutableCatFact.postValue(CatFactStates.Error(error))
    }

}