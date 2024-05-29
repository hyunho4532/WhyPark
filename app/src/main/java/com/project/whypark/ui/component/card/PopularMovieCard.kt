package com.project.whypark.ui.component.card

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.project.parks_domain.entity.PopularMovie
import com.project.parks_domain.util.Constants

@Composable
fun PopularMovieCard(popularMovie: PopularMovie) {

    Card (
        modifier = Modifier
            .padding(12.dp, 0.dp, 0.dp, 0.dp)
            .background(Color.White)
            .width(240.dp)
            .height(220.dp)
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {

            Text (
                text = popularMovie.title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            AsyncImage(
                model = Constants.getPosterPath("popularMovie", popularMovie, null),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.height(160.dp).width(240.dp)
            )
        }
    }
}
