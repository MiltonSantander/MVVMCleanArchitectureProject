package com.example.mvvmcleanarchitectureproject.presentation.di.core

import com.example.mvvmcleanarchitectureproject.presentation.di.artist.ArtistSubComponent
import com.example.mvvmcleanarchitectureproject.presentation.di.movie.MovieSubComponent
import com.example.mvvmcleanarchitectureproject.presentation.di.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetModule::class,
        DatabaseModule::class,
        UseCaseModule::class,
        RepositoryModule::class,
        RemoteDataModule::class,
        LocalDataModule::class,
        CacheDataModule::class
    ]
)
interface AppComponent {
    fun movieSubComponent(): MovieSubComponent.Factory
    fun tvShowSubComponent(): TvShowSubComponent.Factory
    fun artistSubComponent(): ArtistSubComponent.Factory
}