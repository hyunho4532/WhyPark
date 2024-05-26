package com.project.whypark

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.project.parks_datasource.viewmodel.MovieViewModel
import com.project.parks_domain.util.Constants
import com.project.whypark.ui.navigation.RootNavigation
import com.project.whypark.ui.theme.WhyParkTheme

class MainActivity : ComponentActivity() {

    private val movieViewModel: MovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        movieViewModel.fetchPopularMovies(Constants.API_KEY)

        setContent {
            WhyParkTheme {
                RootNavigation(this, movieViewModel)
            }
        }
    }
}