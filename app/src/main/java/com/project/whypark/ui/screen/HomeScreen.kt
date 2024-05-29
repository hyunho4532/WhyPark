package com.project.whypark.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleOwner
import com.project.parks_datasource.viewmodel.MovieViewModel
import com.project.whypark.ui.component.item.PopularMovieItem
import com.project.whypark.ui.component.item.TopRatedMovieItem

@Composable
fun HomeScreen(lifecycleOwner: LifecycleOwner, movieViewModel: MovieViewModel) {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column (
            modifier = Modifier.padding(16.dp)
        ) {
            Text (
                text = "최근 유행하는 영화 😀😀",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            PopularMovieItem(lifecycleOwner, movieViewModel.popularMovies)

            Spacer(modifier = Modifier.padding(top = 32.dp))

            Text (
                text = "압도적 평가를 받은 영화 😎😎",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            TopRatedMovieItem(lifecycleOwner, movieViewModel.topRatedMovies)
        }
    }
}