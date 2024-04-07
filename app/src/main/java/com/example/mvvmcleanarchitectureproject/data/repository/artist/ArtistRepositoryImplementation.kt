package com.example.mvvmcleanarchitectureproject.data.repository.artist

import android.util.Log
import com.example.mvvmcleanarchitectureproject.data.model.artist.Artist
import com.example.mvvmcleanarchitectureproject.domain.repository.ArtistRepository

class ArtistRepositoryImplementation(
    private val remoteDataSource: ArtistRemoteDataSource,
    private val localDataSource: ArtistLocalDataSource,
    private val cacheDataSource: ArtistCacheDataSource
) : ArtistRepository {

    override suspend fun getArtistList(): List<Artist>? {
        return getArtistListFromCache()
    }

    override suspend fun updateArtistList(): List<Artist>? {
        TODO("Not yet implemented")
    }

    suspend fun getArtistListFromCache(): List<Artist>? {
        lateinit var artistList: List<Artist>

        try {
            artistList = cacheDataSource.getArtistListFromCache()
        } catch (exception: Exception) {
            Log.i("exceptionTag", exception.message.toString())
        }
        if (artistList.isNotEmpty()) {
            return artistList
        } else {
            artistList = getArtistListFromDB()
            cacheDataSource.saveArtistListToCache(artistList)
        }

        return artistList
    }

    suspend fun getArtistListFromDB(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            artistList = localDataSource.getArtistListFromDB()
        } catch (exception: Exception) {
            Log.i("exceptionTag", exception.message.toString())
        }
        if (artistList.isNotEmpty()) {
            return artistList
        } else {
            artistList = getArtistListFromAPI()
            localDataSource.saveArtistListToDB(artistList)
        }

        return artistList
    }

    suspend fun getArtistListFromAPI(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            val response = remoteDataSource.getArtistList()
            if (response.body() != null) {
                artistList = response.body()!!.artistList
            }
        } catch (exception: Exception) {
            Log.i("exceptionTag", exception.message.toString())
        }

        return artistList
    }
}