package com.example.movielistmvvm.ui.movies
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movielistmvvm.util.Corotines
import com.example.movielistmvvm.data.repository.MoviesRepository
import com.example.movielistmvvm.data.model.MoviesResponceModel
import kotlinx.coroutines.Job

// we need instance of Movies Repository
class MoviesViewModel(private val repository: MoviesRepository) : ViewModel() {
       // TODO: Implement the ViewModel
     //we need MutableLiveData for storing data it's like a Arraylist
    // we should not expose mutable livedata outside of the Class that is why declare private

    private lateinit var job: Job

    private val _movies = MutableLiveData<List<MoviesResponceModel>>()
    // live data make it pubic it will access outside the class
    val movies : LiveData<List<MoviesResponceModel>>
    get() = _movies

    // we just calling getMovies Function for fitch data
     fun getMovies(){
        job = Corotines.ioThenMain(
            {repository.getMovies()},
            {_movies.value = it}// it contains list of movies
        )
    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }
}