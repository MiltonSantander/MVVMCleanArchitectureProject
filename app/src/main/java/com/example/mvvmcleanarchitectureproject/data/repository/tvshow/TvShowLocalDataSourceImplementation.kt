package com.example.mvvmcleanarchitectureproject.data.repository.tvshow

import com.example.mvvmcleanarchitectureproject.data.db.TvShowDAO
import com.example.mvvmcleanarchitectureproject.data.model.tvshow.TvShow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImplementation(private val tvShowDAO: TvShowDAO) :
    TvShowLocalDataSource {
    override suspend fun getTvShowListFromDB(): List<TvShow> {
        return tvShowDAO.getTvShowList()
    }

    override suspend fun saveTvShowListToDB(tvShowList: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDAO.saveTvShowList(tvShowList)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDAO.deleteTvShowList()
        }
    }
}