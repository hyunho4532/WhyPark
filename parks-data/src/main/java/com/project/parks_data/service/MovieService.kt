package com.project.parks_data.service

import android.telecom.Call
import com.project.parks_domain.entity.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("movie/popular")
    fun getPopularMovies (
        @Query("api_key") apiKey: String,
        @Query("language") language: String = "ko-KR",
        @Query("page") page: Int = 1
    ): Call<MovieResponse>
}