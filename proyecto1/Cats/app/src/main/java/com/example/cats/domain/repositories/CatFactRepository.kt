package com.example.cats.domain.repositories

import com.example.cats.domain.model.CatFactStates

interface CatFactRepository {
    suspend fun getCatRandomFact(): CatFactStates
}