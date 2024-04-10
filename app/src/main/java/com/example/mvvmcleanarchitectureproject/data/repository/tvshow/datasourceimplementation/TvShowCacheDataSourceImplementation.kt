package com.example.mvvmcleanarchitectureproject.data.repository.tvshow.datasourceimplementation

import com.example.mvvmcleanarchitectureproject.data.model.tvshow.TvShow
import com.example.mvvmcleanarchitectureproject.data.repository.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImplementation : TvShowCacheDataSource {
    private var tvShowList = ArrayList<TvShow>()
    override suspend fun getTvShowListFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowListToCache(tvShowListArgument: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShowListArgument)
    }
}