package com.example.movielistmvvm.ui.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movielistmvvm.data.repository.MoviesRepository

@Suppress("UNCHECKED_CAST")
class MoviesViewModelFactory(
    private val repository: MoviesRepository
) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MoviesViewModel(repository) as T
    }
    // this MoviesViewModelFactory return MoviesViewModel that has repository as the parameter
}