package com.project.parks_domain.util

import com.project.parks_domain.entity.Movie

object Constants {
    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val API_KEY: String = "dd67dfcedd4c89d02c48749b52d75952"

    fun getPosterPath(movie: Movie): String {
        return "https://image.tmdb.org/t/p/original${movie.poster_path}"
    }
}