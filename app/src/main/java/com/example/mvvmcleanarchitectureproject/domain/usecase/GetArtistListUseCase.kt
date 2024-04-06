package com.example.mvvmcleanarchitectureproject.domain.usecase

import com.example.mvvmcleanarchitectureproject.domain.repository.ArtistRepository

class GetArtistListUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute() = artistRepository.getArtistList()
}