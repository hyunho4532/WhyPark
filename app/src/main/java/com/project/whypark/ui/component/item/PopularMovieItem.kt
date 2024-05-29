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
import com.project.whypark.ui.component.card.PopularMovieCard

@Composable
fun PopularMovieItem(lifecycleOwner: LifecycleOwner, movies: LiveData<List<PopularMovie>>) {

    val popularMovieListState = remember { mutableStateOf<List<PopularMovie>>(emptyList()) }

    DisposableEffect(key1 = lifecycleOwner) {
        val popularPopularMovieObserver = Observer<List<PopularMovie>> { movies ->
            popularMovieListState.value = movies // 값 설정
        }
        movies.observe(lifecycleOwner, popularPopularMovieObserver)

        onDispose {
            movies.removeObserver(popularPopularMovieObserver)
        }
    }

    LazyRow (
        contentPadding = PaddingValues(0.dp, 20.dp)
    ) {
        items (
            items = popularMovieListState.value, // 값 가져오기
            itemContent = { popularMovie ->
                PopularMovieCard(popularMovie)
            }
        )
    }
}