package com.example.mvvmcleanarchitectureproject.data.repository.tvshow

import android.util.Log
import com.example.mvvmcleanarchitectureproject.data.model.tvshow.TvShow
import com.example.mvvmcleanarchitectureproject.domain.repository.TvShowRepository

class TvShowRepositoryImplementation(
    private val remoteDataSource: TvShowRemoteDataSource,
    private val localDataSource: TvShowLocalDataSource,
    private val cacheDataSource: TvShowCacheDataSource
) : TvShowRepository {

    override suspend fun getTvShowList(): List<TvShow>? {
        return getTvShowListFromCache()
    }

    override suspend fun updateTvShowList(): List<TvShow>? {
        val newTvShowList = getTvShowListFromAPI()
        localDataSource.clearAll()
        localDataSource.saveTvShowListToDB(newTvShowList)
        cacheDataSource.saveTvShowListToCache(newTvShowList)
        return newTvShowList
    }

    suspend fun getTvShowListFromAPI(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
            val response = remoteDataSource.getTvShowList()
            if (response.body() != null) {
                tvShowList = response.body()!!.tvShowList
            }
        } catch (exception: Exception) {
            Log.i("exceptionTag", exception.message.toString())
        }

        return tvShowList
    }

    suspend fun getTvShowListFromDB(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
            tvShowList = localDataSource.getTvShowListFromDB()
        } catch (exception: Exception) {
            Log.i("exceptionTag", exception.message.toString())
        }
        if (tvShowList.isNotEmpty()) {
            return tvShowList
        } else {
            tvShowList = getTvShowListFromAPI()
            localDataSource.saveTvShowListToDB(tvShowList)
        }

        return tvShowList
    }

    suspend fun getTvShowListFromCache(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
            tvShowList = cacheDataSource.getTvShowListFromCache()
        } catch (exception: Exception) {
            Log.i("exceptionTag", exception.message.toString())
        }
        if (tvShowList.isNotEmpty()) {
            return tvShowList
        } else {
            tvShowList = getTvShowListFromDB()
            cacheDataSource.saveTvShowListToCache(tvShowList)
        }

        return tvShowList
    }
}