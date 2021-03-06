package com.example.movielistmvvm.ui.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movielistmvvm.data.model.MoviesResponceModel
import com.example.movielistmvvm.R
import com.example.movielistmvvm.databinding.RecyclerviewItemBinding

class MoviesAdapter (
    private val movies: List<MoviesResponceModel>,
    private val listener: RecyclerViewClickListener
): RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>(){

    override fun getItemCount() = movies.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MoviesViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.recyclerview_item,parent,false
            )
        )

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.recyclerviewItemBinding.movieitemView  = movies[position]
        holder.recyclerviewItemBinding.buttonBook.setOnClickListener{
            listener.onRecyclerviewItemClick(holder.recyclerviewItemBinding.buttonBook,movies[position])
        }
        holder.recyclerviewItemBinding.layoutLike.setOnClickListener{
            listener.onRecyclerviewItemClick(holder.recyclerviewItemBinding.layoutLike,movies[position])
        }
    }

    inner class MoviesViewHolder(
        val recyclerviewItemBinding: RecyclerviewItemBinding
    ): RecyclerView.ViewHolder(recyclerviewItemBinding.root)
}