package com.sena.nuevoxd.data.repository

import com.sena.nuevoxd.data.remote.dto.toDomain
import com.sena.nuevoxd.domain.model.Pokemon
import com.sena.nuevoxd.domain.repository.PokemonRepository
import jakarta.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val pokemonApi: PokemonApi
) : PokemonRepository {
    override suspend fun getPokemons(): List<Pokemon> {
        val response = pokemonApi.getPokemons()
        return response.results.map { it.toDomain() }
    }
}