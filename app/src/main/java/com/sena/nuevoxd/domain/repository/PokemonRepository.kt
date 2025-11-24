package com.sena.nuevoxd.domain.repository

import com.sena.nuevoxd.domain.model.Pokemon

interface PokemonRepository {

    suspend fun getPokemons(): List<Pokemon>

}