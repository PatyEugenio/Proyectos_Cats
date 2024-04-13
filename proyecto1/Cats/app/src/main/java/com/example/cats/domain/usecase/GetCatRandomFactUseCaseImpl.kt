package com.example.cats.domain.usecase

import com.example.cats.domain.model.CatFactStates
import com.example.cats.domain.repositories.CatFactRepository

class GetCatRandomFactUseCaseImpl (  private val catFactRepository: CatFactRepository
): GetCatRandomFactUseCase {
    override suspend fun invoke(): CatFactStates = catFactRepository.getCatRandomFact()
}
