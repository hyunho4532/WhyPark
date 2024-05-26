package com.project.whypark.ui.component.item

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.project.parks_domain.entity.PopularMovie
import com.project.parks_domain.entity.TopRatedMovie
import com.project.whypark.ui.component.card.PopularMovieCard
import com.project.whypark.ui.component.card.TopRatedMovieCard

@Composable
fun TopRatedMovieItem(lifecycleOwner: LifecycleOwner, movies: LiveData<List<TopRatedMovie>>) {

    val topRatedMovieListState = remember { mutableStateOf<List<TopRatedMovie>>(emptyList()) }

    DisposableEffect(key1 = lifecycleOwner) {
        val topRatedMovieObserver = Observer<List<TopRatedMovie>> { movies ->
            topRatedMovieListState.value = movies
        }

        movies.observe(lifecycleOwner, topRatedMovieObserver)

        onDispose {
            movies.removeObserver(topRatedMovieObserver)
        }
    }

    LazyRow (
        contentPadding = PaddingValues(0.dp, 20.dp)
    ) {
        items (
            items = topRatedMovieListState.value,
            itemContent = { topRatedMovie ->
                TopRatedMovieCard(topRatedMovie)
            }
        )
    }
}