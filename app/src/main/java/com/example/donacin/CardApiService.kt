package com.example.donacin

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET


interface CardApiService {
    @GET("character")
    suspend fun getCharacter(): String
}

private var retrofit = Retrofit.Builder()
    .baseUrl("https://rickandmortyapi.com/api")
    .addConverterFactory(ScalarsConverterFactory.create())
    .build()

val service: CardApiService = retrofit.create(CardApiService::class.java)
