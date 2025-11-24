package com.sena.nuevoxd.data.remote.dto

import com.sena.nuevoxd.domain.model.Pokemon
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonDto (
    @Json(name = "name")
    val name: String,
    @Json(name = "name")
    val url: String,
)

@JsonClass(generateAdapter = true)
data class PokemonResponseDto (
    @Json(name = "results")
    val results: List<PokemonDto>,
)


fun PokemonDto.toDomain(): Pokemon {
    return Pokemon(
        name = name,
        url = url,
    )
}
