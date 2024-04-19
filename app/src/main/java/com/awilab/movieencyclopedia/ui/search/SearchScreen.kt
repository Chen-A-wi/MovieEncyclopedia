package com.awilab.movieencyclopedia.ui.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.awilab.movieencyclopedia.Greeting
import com.awilab.movieencyclopedia.ui.theme.MovieEncyclopediaTheme
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootGraph
import org.koin.androidx.compose.koinViewModel

@Destination<RootGraph>
@Composable
fun SearchScreen(
//    viewModel: SearchViewModel = koinViewModel(),
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "TestScreen")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    MovieEncyclopediaTheme {
        SearchScreen()
    }
}
