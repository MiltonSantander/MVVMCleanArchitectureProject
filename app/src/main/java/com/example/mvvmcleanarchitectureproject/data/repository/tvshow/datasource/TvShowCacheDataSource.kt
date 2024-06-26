package com.example.mvvmcleanarchitectureproject.data.repository.tvshow.datasource

import com.example.mvvmcleanarchitectureproject.data.model.tvshow.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowListFromCache(): List<TvShow>
    suspend fun saveTvShowListToCache(tvShowListArgument: List<TvShow>)
}