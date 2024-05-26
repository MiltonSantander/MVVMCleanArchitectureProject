package com.example.mvvmcleanarchitectureproject.presentation.tvshow

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmcleanarchitectureproject.R
import com.example.mvvmcleanarchitectureproject.data.model.tvshow.TvShow
import com.example.mvvmcleanarchitectureproject.databinding.ActivityTvShowBinding
import com.example.mvvmcleanarchitectureproject.presentation.GeneralPurposeAdapter
import com.example.mvvmcleanarchitectureproject.presentation.di.Injector
import javax.inject.Inject

class TvShowActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: TvShowViewModelFactory
    private lateinit var tvShowViewModel: TvShowViewModel
    private lateinit var binding: ActivityTvShowBinding
    private lateinit var generalPurposeAdapter: GeneralPurposeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)
        (application as Injector).createTvShowSubComponent().inject(this)
        tvShowViewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]
        val responseLiveData: LiveData<List<TvShow>?> = tvShowViewModel.getTvShowList()
        generalPurposeAdapter = GeneralPurposeAdapter()
        binding.tvShowRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.tvShowRecyclerView.adapter = generalPurposeAdapter
        binding.tvShowProgressBar.visibility = View.VISIBLE
        responseLiveData.observe(this) {
            if (it != null) {
                generalPurposeAdapter.setList(it)
                generalPurposeAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "No data available", Toast.LENGTH_LONG).show()
            }
            binding.tvShowProgressBar.visibility = View.GONE
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_update -> {
                updateTvShowList()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateTvShowList() {
        binding.tvShowProgressBar.visibility = View.VISIBLE
        val response: LiveData<List<TvShow>?> = tvShowViewModel.getTvShowList()
        response.observe(this) {
            if (it != null) {
                generalPurposeAdapter.setList(it)
                generalPurposeAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "No data available", Toast.LENGTH_LONG).show()
            }
            binding.tvShowProgressBar.visibility = View.GONE
        }
    }
}