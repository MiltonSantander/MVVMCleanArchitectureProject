package com.example.mvvmcleanarchitectureproject.presentation.di

import com.example.mvvmcleanarchitectureproject.presentation.di.artist.ArtistSubComponent
import com.example.mvvmcleanarchitectureproject.presentation.di.movie.MovieSubComponent
import com.example.mvvmcleanarchitectureproject.presentation.di.tvshow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
}