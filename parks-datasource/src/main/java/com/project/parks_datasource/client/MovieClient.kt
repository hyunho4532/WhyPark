package com.project.parks_datasource.client

import MovieService
import com.project.parks_domain.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MovieClient {
    val instance: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val tmdbService: MovieService by lazy {
        instance.create(MovieService::class.java)
    }
}