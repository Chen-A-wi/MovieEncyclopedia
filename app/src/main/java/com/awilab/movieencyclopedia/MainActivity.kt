package com.awilab.movieencyclopedia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.awilab.movieencyclopedia.ui.theme.MovieEncyclopediaTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootGraph
import com.ramcosta.composedestinations.generated.NavGraphs
import com.ramcosta.composedestinations.generated.destinations.SearchScreenDestination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieEncyclopediaTheme {
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }
}

@Destination<RootGraph>(start = true)
@Composable
fun MainScreen(navigator: DestinationsNavigator){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hello Android!"
        )
        Button(onClick = {
            navigator.navigate(SearchScreenDestination())
        }) {
            Text(text = "Next Page")
        }
    }
}

@Composable
fun Greeting(navigator: DestinationsNavigator) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hello Android!"
        )
        Button(onClick = {
//            navigator.navigate(SearchScreenDestination)
        }) {
            Text(text = "Next Page")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MovieEncyclopediaTheme {
//        Greeting("Android")
    }
}
