package com.example.mvvmcleanarchitectureproject.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.mvvmcleanarchitectureproject.R
import com.example.mvvmcleanarchitectureproject.databinding.ActivityHomeBinding
import com.example.mvvmcleanarchitectureproject.presentation.artist.ArtistActivity
import com.example.mvvmcleanarchitectureproject.presentation.movie.MovieActivity
import com.example.mvvmcleanarchitectureproject.presentation.tvshow.TvShowActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.movieButton.setOnClickListener {
            startActivity(Intent(this, MovieActivity::class.java))
        }

        binding.tvButton.setOnClickListener {
            startActivity(Intent(this, TvShowActivity::class.java))
        }

        binding.artistButton.setOnClickListener {
            startActivity(Intent(this, ArtistActivity::class.java))
        }
    }
}