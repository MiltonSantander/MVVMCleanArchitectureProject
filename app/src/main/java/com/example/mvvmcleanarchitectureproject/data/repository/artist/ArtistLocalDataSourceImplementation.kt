package com.example.mvvmcleanarchitectureproject.data.repository.artist

import com.example.mvvmcleanarchitectureproject.data.db.ArtistDAO
import com.example.mvvmcleanarchitectureproject.data.model.artist.Artist
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImplementation(private val artistDAO: ArtistDAO) :
    ArtistLocalDataSource {
    override suspend fun getArtistListFromDB(): List<Artist> {
        return artistDAO.getArtistList()
    }

    override suspend fun saveArtistListToDB(artistList: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDAO.saveArtistList(artistList)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDAO.deleteArtistList()
        }
    }
}