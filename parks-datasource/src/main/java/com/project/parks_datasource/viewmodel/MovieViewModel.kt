package com.project.parks_datasource.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.parks_datasource.client.MovieClient
import com.project.parks_domain.entity.PopularMovie
import com.project.parks_domain.entity.PopularMovieResponse
import com.project.parks_domain.entity.TopRatedMovie
import com.project.parks_domain.entity.TopRatedMovieResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel : ViewModel() {

    private val _popularMovies = MutableLiveData<List<PopularMovie>>()
    private val _topRatedMovies = MutableLiveData<List<TopRatedMovie>>()

    val popularMovies: LiveData<List<PopularMovie>> get() = _popularMovies
    val topRatedMovies: LiveData<List<TopRatedMovie>> get() = _topRatedMovies

    fun fetchPopularMovies(apiKey: String) {
        MovieClient.tmdbService.getPopularMovies(apiKey).enqueue(object: Callback<PopularMovieResponse> {
            override fun onResponse(call: Call<PopularMovieResponse>, response: Response<PopularMovieResponse>) {
                if (response.isSuccessful) {
                    _popularMovies.value = response.body()?.results
                }
            }

            override fun onFailure(call: Call<PopularMovieResponse>, t: Throwable) {

            }

        })
    }

    fun fetchTopRatedMovies(apiKey: String) {
        MovieClient.tmdbService.getTopRatedMovies(apiKey).enqueue(object: Callback<TopRatedMovieResponse> {
            override fun onResponse(call: Call<TopRatedMovieResponse>, response: Response<TopRatedMovieResponse>) {
                if (response.isSuccessful) {
                    _topRatedMovies.value = response.body()?.results
                }
            }

            override fun onFailure(call: Call<TopRatedMovieResponse>, t: Throwable) {

            }
        })
    }
}