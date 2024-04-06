package com.example.mvvmcleanarchitectureproject.data.db

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvmcleanarchitectureproject.data.model.tvshow.TvShow

interface TvShowDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShowList(tvShow: List<TvShow>)

    @Query("SELECT * FROM popular_tvshow")
    suspend fun getTvShowList(): List<TvShow>

    @Query("DELETE FROM popular_tvshow")
    suspend fun deleteTvShowList()
}