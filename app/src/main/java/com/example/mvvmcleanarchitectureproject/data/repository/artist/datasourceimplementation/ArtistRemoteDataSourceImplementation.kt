package com.example.mvvmcleanarchitectureproject.data.repository.artist.datasourceimplementation

import com.example.mvvmcleanarchitectureproject.data.api.TMDBApi
import com.example.mvvmcleanarchitectureproject.data.model.artist.ArtistListResponse
import com.example.mvvmcleanarchitectureproject.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImplementation(
    private val tmdbApi: TMDBApi,
    private val apiKey: String
) : ArtistRemoteDataSource {
    override suspend fun getArtistList(): Response<ArtistListResponse> {
        return tmdbApi.getPopularArtistList(apiKey)
    }
}