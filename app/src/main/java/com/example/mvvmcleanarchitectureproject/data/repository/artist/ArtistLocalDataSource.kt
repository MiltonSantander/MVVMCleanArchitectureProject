package com.example.mvvmcleanarchitectureproject.data.repository.artist

import com.example.mvvmcleanarchitectureproject.data.model.artist.Artist

interface ArtistLocalDataSource {
    suspend fun getArtistListFromDB(): List<Artist>
    suspend fun saveArtistListToDB(movieList: List<Artist>)
    suspend fun clearAll()
}