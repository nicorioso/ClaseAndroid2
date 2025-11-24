package com.sena.nuevoxd.data.repository

import com.sena.nuevoxd.data.remote.dto.PokemonResponseDto
import retrofit2.http.GET

interface PokemonApi {
    @GET(value = "pokemon")
    suspend fun getPokemons(): PokemonResponseDto
}
