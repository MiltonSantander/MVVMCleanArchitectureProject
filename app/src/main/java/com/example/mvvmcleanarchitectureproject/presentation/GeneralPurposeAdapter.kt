package com.example.mvvmcleanarchitectureproject.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmcleanarchitectureproject.R
import com.example.mvvmcleanarchitectureproject.data.model.artist.Artist
import com.example.mvvmcleanarchitectureproject.data.model.movie.Movie
import com.example.mvvmcleanarchitectureproject.data.model.tvshow.TvShow
import com.example.mvvmcleanarchitectureproject.databinding.ListItemBinding

class GeneralPurposeAdapter() :
    RecyclerView.Adapter<GeneralPurposeAdapter.ViewHolder>() {

    private val itemList = ArrayList<Any>()

    fun setList(items: List<Any>) {
        itemList.clear()
        itemList.addAll(items)
    }

    fun getItemData(item: Any): HashMap<String, String> {
        val itemData = HashMap<String, String>()

        if (item is Movie) {
            itemData["titleTextView"] = item.title
            itemData["descriptionTextView"] = item.overview
            itemData["imageUrl"] = item.posterPath
        }

        if (item is Artist) {
            itemData["titleTextView"] = item.name
            itemData["descriptionTextView"] = item.popularity.toString()
            itemData["imageUrl"] = item.profilePath
        }

        if (item is TvShow) {
            itemData["titleTextView"] = item.name
            itemData["descriptionTextView"] = item.overview
            itemData["imageUrl"] = item.posterPath
        }

        return itemData
    }

    inner class ViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Any) {
            val itemData = getItemData(item)
            binding.titleTextView.text = itemData["titleTextView"]
            binding.descriptionTextView.text = itemData["descriptionTextView"]
            Glide.with(binding.imageView.context)
                .load("https://image.tmdb.org/t/p/w500${itemData["imageUrl"]}")
                .into(binding.imageView)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}