package com.sena.nuevoxd.presentation.pokemon

import com.sena.nuevoxd.domain.model.Pokemon

data class pokemonUiState (
    val isLoading: Boolean = false,
    val pokemons: List<Pokemon> = emptyList(),
    val errorMessage: String? = null
)