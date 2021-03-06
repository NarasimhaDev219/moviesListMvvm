package com.example.movielistmvvm.data.repository

import com.example.movielistmvvm.data.network.MoviesApi

class MoviesRepository(private val api: MoviesApi) : SafeApiRequest() {

    suspend fun getMovies() = appiRequest { api.getMovies() }
}