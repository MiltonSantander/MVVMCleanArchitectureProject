package com.example.mvvmcleanarchitectureproject.data.repository.tvshow.datasource

import com.example.mvvmcleanarchitectureproject.data.model.tvshow.TvShowListResponse
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShowList(): Response<TvShowListResponse>
}