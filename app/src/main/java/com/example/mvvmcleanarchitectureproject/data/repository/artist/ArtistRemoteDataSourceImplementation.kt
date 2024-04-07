package com.example.mvvmcleanarchitectureproject.data.repository.artist

import com.example.mvvmcleanarchitectureproject.data.api.TMDBApi
import com.example.mvvmcleanarchitectureproject.data.model.artist.ArtistListResponse
import retrofit2.Response

class ArtistRemoteDataSourceImplementation(
    private val tmdbApi: TMDBApi,
    private val apiKey: String
) : ArtistRemoteDataSource {
    override suspend fun getArtistList(): Response<ArtistListResponse> {
        return tmdbApi.getPopularArtistList(apiKey)
    }
}