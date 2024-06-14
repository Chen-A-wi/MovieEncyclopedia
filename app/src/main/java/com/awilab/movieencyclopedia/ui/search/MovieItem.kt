package com.awilab.movieencyclopedia.ui.search

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.awilab.movieencyclopedia.R
import com.awilab.movieencyclopedia.ui.theme.MovieEncyclopediaTheme

@Composable
fun MovieItem(modifier: Modifier) {
    ConstraintLayout {
        val (imgId, titleId) = createRefs()

        SubcomposeAsyncImage(
            contentScale = ContentScale.FillHeight,
            model = ImageRequest.Builder(LocalContext.current)
                .crossfade(true)
                .data("https://image.tmdb.org/t/p/original/bOGkgRGdhrBYJSLpXaxhXVstddV.jpg")
                .size(720, 360).build(),
            contentDescription = stringResource(id = R.string.lab_search),
            modifier = modifier.constrainAs(imgId) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            loading = {
                CircularProgressIndicator()
            },
        )

        Text(
            text = "Movie Title",
            modifier = modifier.constrainAs(titleId) {
                top.linkTo(imgId.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            },
        )
    }
}

@Preview
@Composable
fun MovieItemPreview() {
    MovieEncyclopediaTheme {
        MovieItem(
            Modifier,
        )
    }
}
