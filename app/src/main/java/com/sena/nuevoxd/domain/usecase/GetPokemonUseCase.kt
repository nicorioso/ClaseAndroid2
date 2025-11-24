package com.sena.nuevoxd.domain.usecase

import com.sena.nuevoxd.domain.model.Pokemon
import com.sena.nuevoxd.domain.repository.PokemonRepository
import javax.inject.Inject

class GetPokemonUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
){
    suspend operator fun invoke(): List<Pokemon> {
        return pokemonRepository.getPokemons()
    }
}