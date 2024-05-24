package com.example.mvvmcleanarchitectureproject.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmcleanarchitectureproject.R
import com.example.mvvmcleanarchitectureproject.data.model.movie.Movie
import com.example.mvvmcleanarchitectureproject.databinding.ActivityMovieBinding
import com.example.mvvmcleanarchitectureproject.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var binding: ActivityMovieBinding
    private lateinit var generalPurposeAdapter: GeneralPurposeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)
        (application as Injector).createMovieSubComponent()
            .inject(this)
        movieViewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]
        val responseLiveData: LiveData<List<Movie>?> = movieViewModel.getMovieList()
        generalPurposeAdapter = GeneralPurposeAdapter()
        binding.movieRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.movieRecyclerView.adapter = generalPurposeAdapter
        binding.movieProgressBar.visibility = View.VISIBLE
        responseLiveData.observe(this) {
            if (it != null) {
                generalPurposeAdapter.setList(it)
                generalPurposeAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "No data available", Toast.LENGTH_LONG).show()
            }
            binding.movieProgressBar.visibility = View.GONE
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_update -> {
                updateMovieList()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateMovieList() {
        binding.movieProgressBar.visibility = View.VISIBLE
        val response: LiveData<List<Movie>?> = movieViewModel.getMovieList()
        response.observe(this) {
            if (it != null) {
                generalPurposeAdapter.setList(it)
                generalPurposeAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "No data available", Toast.LENGTH_LONG).show()
            }
            binding.movieProgressBar.visibility = View.GONE
        }
    }
}