package com.example.mvvmcleanarchitectureproject.data.repository.tvshow

import com.example.mvvmcleanarchitectureproject.data.model.tvshow.TvShow

class tvShowCacheDataSourceImplementation : TvShowCacheDataSource {
    private var tvShowList = ArrayList<TvShow>()
    override suspend fun getTvShowListFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowListToCache(tvShowListArgument: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShowListArgument)
    }
}