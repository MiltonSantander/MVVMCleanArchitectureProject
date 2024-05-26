package com.example.mvvmcleanarchitectureproject.presentation.artist

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
import com.example.mvvmcleanarchitectureproject.data.model.artist.Artist
import com.example.mvvmcleanarchitectureproject.databinding.ActivityArtistBinding
import com.example.mvvmcleanarchitectureproject.presentation.GeneralPurposeAdapter
import com.example.mvvmcleanarchitectureproject.presentation.di.Injector
import javax.inject.Inject

class ArtistActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ArtistViewModelFactory
    private lateinit var artistViewModel: ArtistViewModel
    private lateinit var binding: ActivityArtistBinding
    private lateinit var generalPurposeAdapter: GeneralPurposeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist)
        (application as Injector).createArtistSubComponent().inject(this)
        artistViewModel = ViewModelProvider(this, factory)[ArtistViewModel::class.java]
        val responseLiveData: LiveData<List<Artist>?> = artistViewModel.getArtistList()
        generalPurposeAdapter = GeneralPurposeAdapter()
        binding.artistRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.artistRecyclerView.adapter = generalPurposeAdapter
        binding.artistProgressBar.visibility = View.VISIBLE
        responseLiveData.observe(this) {
            if (it != null) {
                generalPurposeAdapter.setList(it)
                generalPurposeAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "No data available", Toast.LENGTH_LONG).show()
            }
            binding.artistProgressBar.visibility = View.GONE
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_update -> {
                updateArtistList()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateArtistList() {
        binding.artistProgressBar.visibility = View.VISIBLE
        val response: LiveData<List<Artist>?> = artistViewModel.getArtistList()
        response.observe(this) {
            if (it != null) {
                generalPurposeAdapter.setList(it)
                generalPurposeAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "No data available", Toast.LENGTH_LONG).show()
            }
            binding.artistProgressBar.visibility = View.GONE
        }
    }
}