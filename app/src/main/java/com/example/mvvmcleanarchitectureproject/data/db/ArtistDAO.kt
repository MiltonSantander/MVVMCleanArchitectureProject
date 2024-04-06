package com.example.mvvmcleanarchitectureproject.data.db

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvmcleanarchitectureproject.data.model.artist.Artist

interface ArtistDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtistList(artist: List<Artist>)

    @Query("SELECT * FROM popular_artist")
    suspend fun getArtistList(): List<Artist>

    @Query("DELETE FROM popular_artist")
    suspend fun deleteArtistList()
}