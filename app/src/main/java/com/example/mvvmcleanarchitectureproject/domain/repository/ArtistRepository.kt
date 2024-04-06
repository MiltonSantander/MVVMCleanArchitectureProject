package com.example.mvvmcleanarchitectureproject.domain.repository

import com.example.mvvmcleanarchitectureproject.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtistList(): List<Artist>?
    suspend fun updateArtistList(): List<Artist>?
}