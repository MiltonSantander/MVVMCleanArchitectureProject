package com.example.mvvmcleanarchitectureproject.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmcleanarchitectureproject.domain.usecase.GetArtistListUseCase
import com.example.mvvmcleanarchitectureproject.domain.usecase.UpdateArtistListUseCase

class ArtistViewModelFactory(
    private val getArtistListUseCase: GetArtistListUseCase,
    private val updateArtistListUseCase: UpdateArtistListUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistViewModel(getArtistListUseCase, updateArtistListUseCase) as T
    }
}
