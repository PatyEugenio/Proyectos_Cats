package com.example.cats.data.repositories
import com.example.cats.data.network.CatFactsService
import com.example.cats.domain.model.CatFactStates
import com.example.cats.domain.repositories.CatFactRepository
import java.io.IOException
import javax.inject.Inject

class CatFactRepositoryImpl @Inject constructor (
    private val catFactsService: CatFactsService
): CatFactRepository {
    override suspend fun getCatRandomFact(): CatFactStates {
        return try {
            val response = catFactsService.getCatRandomFact()
            val fact = response.body()
            return if (fact != null) CatFactStates.CatFactData(fact)
            else CatFactStates.Error(IOException("Data is null"))
        } catch (exception: Exception) {
            CatFactStates.Error(exception)
        }
    }
}