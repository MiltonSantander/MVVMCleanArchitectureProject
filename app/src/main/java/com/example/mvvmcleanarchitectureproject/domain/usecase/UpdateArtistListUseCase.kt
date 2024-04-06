package com.example.mvvmcleanarchitectureproject.domain.usecase

import com.example.mvvmcleanarchitectureproject.data.model.artist.Artist
import com.example.mvvmcleanarchitectureproject.domain.repository.ArtistRepository

class UpdateArtistListUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>? = artistRepository.updateArtistList()
}