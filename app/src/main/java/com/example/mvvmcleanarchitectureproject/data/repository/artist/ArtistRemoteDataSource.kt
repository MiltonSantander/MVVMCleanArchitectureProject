package com.example.mvvmcleanarchitectureproject.data.repository.artist

import com.example.mvvmcleanarchitectureproject.data.model.artist.ArtistListResponse
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtistList(): Response<ArtistListResponse>
}