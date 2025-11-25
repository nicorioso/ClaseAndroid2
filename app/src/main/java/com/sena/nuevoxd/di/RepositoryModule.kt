package com.sena.nuevoxd.di

import com.sena.nuevoxd.data.repository.PokemonApi
import com.sena.nuevoxd.data.repository.PokemonRepositoryImpl
import com.sena.nuevoxd.domain.repository.PokemonRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
//    @Provides
//    @Singleton
//    fun providePokemonRepository(
//        pokemonRepositoryImpl: PokemonRepositoryImpl
//    ): PokemonRepositoryImpl {
//        return pokemonRepository
//    }

    @Binds
    @Singleton
    abstract fun bindPokemonRepository(
        impl: PokemonRepositoryImpl
    ): PokemonRepository

}