package com.example.mvvmcleanarchitectureproject.data.repository.tvshow.datasourceimplementation

import com.example.mvvmcleanarchitectureproject.data.api.TMDBApi
import com.example.mvvmcleanarchitectureproject.data.model.tvshow.TvShowListResponse
import com.example.mvvmcleanarchitectureproject.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImplementation(
    private val tmdbApi: TMDBApi,
    private val apiKey: String
) : TvShowRemoteDataSource {
    override suspend fun getTvShowList(): Response<TvShowListResponse> {
        return tmdbApi.getPopularTvShowList(apiKey)
    }
}