package com.project.parks_data.repository

import com.project.parks_data.provider.MovieProvider

class MovieRepository {
    fun getMovieList() : List<Movie> {
        return MovieProvider.movieList
    }
}