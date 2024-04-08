package com.example.mvvmcleanarchitectureproject.data.repository.tvshow.datasource

import com.example.mvvmcleanarchitectureproject.data.model.tvshow.TvShow

interface TvShowLocalDataSource {
    suspend fun getTvShowListFromDB(): List<TvShow>
    suspend fun saveTvShowListToDB(tvShowList: List<TvShow>)
    suspend fun clearAll()
}