package com.example.mvvmcleanarchitectureproject.data.repository.artist.datasource

import com.example.mvvmcleanarchitectureproject.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun getArtistListFromCache(): List<Artist>
    suspend fun saveArtistListToCache(artistList: List<Artist>)
}