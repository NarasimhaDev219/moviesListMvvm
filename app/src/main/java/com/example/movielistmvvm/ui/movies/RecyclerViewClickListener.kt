package com.example.movielistmvvm.ui.movies

import android.view.View
import com.example.movielistmvvm.data.model.MoviesResponceModel

interface RecyclerViewClickListener {
    fun onRecyclerviewItemClick(view: View, movie: MoviesResponceModel
    )
}