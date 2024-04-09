package com.example.mvvmcleanarchitectureproject.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mvvmcleanarchitectureproject.domain.usecase.GetArtistListUseCase
import com.example.mvvmcleanarchitectureproject.domain.usecase.UpdateArtistListUseCase

class ArtistViewModel(
    private val getArtistListUseCase: GetArtistListUseCase,
    private val updateArtistListUseCase: UpdateArtistListUseCase
) : ViewModel() {
    fun getArtist() = liveData { emit(getArtistListUseCase.execute()) }
    fun updateArtist() = liveData { emit(updateArtistListUseCase.execute()) }
}