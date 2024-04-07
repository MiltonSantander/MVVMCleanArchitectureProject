package com.example.mvvmcleanarchitectureproject.data.repository.artist

import com.example.mvvmcleanarchitectureproject.data.model.artist.Artist
import com.example.mvvmcleanarchitectureproject.data.model.movie.Movie

class ArtistCacheDataSourceImplementation : ArtistCacheDataSource {
    private var artistList = ArrayList<Artist>()
    override suspend fun getArtistListFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistListToCache(artistListArgument: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artistListArgument)
    }
}