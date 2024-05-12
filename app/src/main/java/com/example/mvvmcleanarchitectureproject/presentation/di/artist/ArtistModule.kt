package com.example.mvvmcleanarchitectureproject.presentation.di.artist

import com.example.mvvmcleanarchitectureproject.domain.usecase.GetArtistListUseCase
import com.example.mvvmcleanarchitectureproject.domain.usecase.UpdateArtistListUseCase
import com.example.mvvmcleanarchitectureproject.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {
    @ArtistScope
    @Provides
    fun providerArtistViewModelFactory(
        getArtistListUseCase: GetArtistListUseCase,
        updateArtistListUseCase: UpdateArtistListUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(getArtistListUseCase, updateArtistListUseCase)
    }
}