package com.example.mvvmcleanarchitectureproject.presentation

import android.app.Application
import com.example.mvvmcleanarchitectureproject.BuildConfig
import com.example.mvvmcleanarchitectureproject.presentation.di.Injector
import com.example.mvvmcleanarchitectureproject.presentation.di.artist.ArtistSubComponent
import com.example.mvvmcleanarchitectureproject.presentation.di.core.AppComponent
import com.example.mvvmcleanarchitectureproject.presentation.di.core.AppModule
import com.example.mvvmcleanarchitectureproject.presentation.di.core.DaggerAppComponent
import com.example.mvvmcleanarchitectureproject.presentation.di.core.NetModule
import com.example.mvvmcleanarchitectureproject.presentation.di.movie.MovieSubComponent
import com.example.mvvmcleanarchitectureproject.presentation.di.tvshow.TvShowSubComponent

class App : Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }
}