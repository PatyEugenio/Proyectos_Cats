package com.example.cats.di

import com.example.cats.data.network.CatFactsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides//Inyectando clases que no controlamos
    fun provideCatFactsApi(): CatFactsService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CatFactsService::class.java)
    }

    companion object {
        const val BASE_URL = "https://cat-fact.herokuapp.com"
    }
}