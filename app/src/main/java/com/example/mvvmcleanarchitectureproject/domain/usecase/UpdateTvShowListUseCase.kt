package com.example.mvvmcleanarchitectureproject.domain.usecase

import com.example.mvvmcleanarchitectureproject.data.model.tvshow.TvShow
import com.example.mvvmcleanarchitectureproject.domain.repository.TvShowRepository

class UpdateTvShowListUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute(): List<TvShow>? = tvShowRepository.updateTvShowList()
}