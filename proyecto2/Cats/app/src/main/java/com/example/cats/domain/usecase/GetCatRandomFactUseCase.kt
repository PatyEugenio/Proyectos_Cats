package com.example.cats.domain.usecase

import com.example.cats.domain.model.CatFactStates
import kotlinx.coroutines.flow.Flow

interface GetCatRandomFactUseCase {
    suspend operator fun invoke(): Flow<CatFactStates>
}