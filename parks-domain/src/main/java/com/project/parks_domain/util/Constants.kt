package com.project.parks_domain.util

import com.project.parks_domain.entity.PopularMovie
import com.project.parks_domain.entity.TopRatedMovie

object Constants {
    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val API_KEY: String = "dd67dfcedd4c89d02c48749b52d75952"

    fun getPosterPath(status: String, popularMovie: PopularMovie?, topRatedMovie: TopRatedMovie?): String {
        return if (status == "popularMovie") {
            "https://image.tmdb.org/t/p/original${popularMovie!!.poster_path}"
        } else {
            "https://image.tmdb.org/t/p/original${topRatedMovie!!.poster_path}"
        }
    }
}