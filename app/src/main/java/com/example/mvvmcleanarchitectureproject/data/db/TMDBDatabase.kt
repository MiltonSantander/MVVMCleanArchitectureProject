package com.example.mvvmcleanarchitectureproject.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvmcleanarchitectureproject.data.model.artist.Artist
import com.example.mvvmcleanarchitectureproject.data.model.movie.Movie
import com.example.mvvmcleanarchitectureproject.data.model.tvshow.TvShow

@Database(
    entities = [Movie::class, TvShow::class, Artist::class],
    version = 1,
    exportSchema = false
)
abstract class TMDBDatabase : RoomDatabase() {
    abstract val movieDAO: MovieDAO
    abstract val artistDAO: ArtistDAO
    abstract val tvShowDAO: TvShowDAO

    companion object {
        @Volatile
        private var INSTANCE: TMDBDatabase? = null
        fun getInstance(context: Context): TMDBDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TMDBDatabase::class.java,
                        "movie_database"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}