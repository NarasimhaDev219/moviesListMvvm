package com.example.movielistmvvm.ui.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movielistmvvm.R
import com.example.movielistmvvm.data.model.MoviesResponceModel
import com.example.movielistmvvm.data.repository.MoviesRepository
import com.example.movielistmvvm.data.network.MoviesApi
import kotlinx.android.synthetic.main.movies_fragment.*

class MoviesFragment : Fragment(),RecyclerViewClickListener {

    private lateinit var factory: MoviesViewModelFactory
    private lateinit var viewModel: MoviesViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.movies_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //MoviesViewModel not posible to initialize directly so we use  MoviesViewModelFactory class
        // initilize viewModel like this
        val api = MoviesApi()
        val repository =
            MoviesRepository(api)
        factory =
            MoviesViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this,factory).get(MoviesViewModel::class.java)
        viewModel.getMovies()
        viewModel.movies.observe(viewLifecycleOwner, Observer { movies ->

            recyclerview_movie.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter =
                    MoviesAdapter(movies,this)
            }
        })
    }

    override fun onRecyclerviewItemClick(view: View, movie: MoviesResponceModel) {

        when(view.id){
            R.id.button_book -> {
                Toast.makeText(requireContext(),"Button Clicked",Toast.LENGTH_LONG).show()
            }
            R.id.layout_like -> {
                Toast.makeText(requireContext(),"Liked this Movie",Toast.LENGTH_LONG).show()
            }
        }
    }
}