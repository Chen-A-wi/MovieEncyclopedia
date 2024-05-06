package com.awilab.movieencyclopedia.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.awilab.movieencyclopedia.ui.theme.MovieEncyclopediaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieEncyclopediaTheme {
                MainScreen()
            }
        }
    }
}
