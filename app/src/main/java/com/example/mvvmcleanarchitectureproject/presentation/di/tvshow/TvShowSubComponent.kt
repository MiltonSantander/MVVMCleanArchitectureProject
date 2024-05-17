package com.example.mvvmcleanarchitectureproject.presentation.di.tvshow

import com.example.mvvmcleanarchitectureproject.presentation.artist.ArtistActivity
import com.example.mvvmcleanarchitectureproject.presentation.tvshow.TvShowActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): TvShowSubComponent
    }
}