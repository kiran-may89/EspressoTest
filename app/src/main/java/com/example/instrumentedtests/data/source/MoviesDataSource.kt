package com.example.instrumentedtests.data.source

import com.example.instrumentedtests.data.Movie

interface MoviesDataSource {

    fun getMovie(movieId: Int): Movie?

    fun getMovies(): List<Movie>
}