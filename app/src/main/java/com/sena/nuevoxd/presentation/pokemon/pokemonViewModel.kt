package com.sena.nuevoxd.presentation.pokemon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sena.nuevoxd.domain.usecase.GetPokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class pokemonViewModel @Inject constructor(
    private val getPokemonUseCase: GetPokemonUseCase
) : ViewModel(){
    private val _uiState = MutableStateFlow(pokemonUiState())
    val uiState: StateFlow<pokemonUiState> = _uiState.asStateFlow()

    init {
        loadPokemons()
    }

    fun loadPokemons() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(
                isLoading = true,
                errorMessage = null
            )

            try {
                val pokemons = getPokemonUseCase()
                _uiState.value = _uiState.value.copy(
                    pokemons = pokemons,
                    isLoading = false,
                    errorMessage = null
                )
            } catch (e: Exception) {
                e.printStackTrace()
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    errorMessage = e.message ?: "Error al cargar los datos de los pokemones"
                )
            }
        }
    }
}