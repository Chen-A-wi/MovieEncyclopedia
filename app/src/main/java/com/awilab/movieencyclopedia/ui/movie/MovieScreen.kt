package com.awilab.movieencyclopedia.ui.movie

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.awilab.movieencyclopedia.R
import com.awilab.movieencyclopedia.ui.widgets.Appbar
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootGraph
import org.koin.androidx.compose.koinViewModel

// TODO: Tag區塊 可參考：https://developer.android.com/develop/ui/compose/layouts/flow?hl=zh-tw

@OptIn(ExperimentalMaterial3Api::class)
@Destination<RootGraph>(start = true)
@Composable
fun MovieScreen(
    navController: NavController,
    vm: MovieViewModel = koinViewModel(),
) {
    Scaffold(
        topBar = {
            Appbar(titleRes = R.string.lab_movie)
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .clickable {
                },
        ) {
            Text(text = "Hello Movie Screen")
        }
    }
}
