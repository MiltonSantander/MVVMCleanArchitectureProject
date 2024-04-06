package com.example.mvvmcleanarchitectureproject.domain.repository

import com.example.mvvmcleanarchitectureproject.data.model.tvshow.TvShow

interface TvShowRepository {
    suspend fun getTvShowList(): List<TvShow>?
    suspend fun updateTvShowList(): List<TvShow>?
}