package com.example.cats.domain.usecase

import com.example.cats.domain.model.CatFactStates
import com.example.cats.domain.repositories.CatFactRepository
import kotlinx.coroutines.flow.Flow

class GetCatRandomFactUseCaseImpl (  private val catFactRepository: CatFactRepository
): GetCatRandomFactUseCase {
    override suspend fun invoke(): Flow<CatFactStates> = catFactRepository.getCatRandomFact()
}
