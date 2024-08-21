package com.awilab.movieencyclopedia.ui.search

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.awilab.domain.model.movie.Movie
import com.awilab.movieencyclopedia.R
import com.awilab.movieencyclopedia.ui.theme.MovieEncyclopediaTheme

@Composable
fun MovieItem(movieData: Movie) {
    Card {
        SubcomposeAsyncImage(
            contentScale = ContentScale.Fit,
            model = ImageRequest.Builder(LocalContext.current)
                .crossfade(true)
                .data("https://image.tmdb.org/t/p/w500${movieData.posterPath}")
                .size(360, 720)
                .build(),
            contentDescription = stringResource(id = R.string.lab_search),
            modifier = Modifier.fillMaxSize(),
            loading = {
                CircularProgressIndicator()
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MovieItemPreview() {
    MovieEncyclopediaTheme {
        MovieItem(
            movieData = Movie(
                isAdult = false,
                backdropPath = "/5QEtCBM6aXHftr7sgFxxUUl9Ej8.jpg",
                genreIds = listOf(),
                id = 0,
                originalLanguage = "",
                originalTitle = "",
                overview = "",
                popularity = 0.0,
                posterPath = "",
                releaseDate = "",
                title = "",
                isVideo = false,
                voteAverage = 0.0,
                voteCount = 0,
            ),
        )
    }
}
