package com.example.cats.domain.usecase

import com.example.cats.domain.model.CatFactStates

interface GetCatRandomFactUseCase {
    suspend operator fun invoke(): CatFactStates
}