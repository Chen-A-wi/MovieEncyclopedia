package com.awilab.movieencyclopedia.ui.setting

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

@OptIn(ExperimentalMaterial3Api::class)
@Destination<RootGraph>()
@Composable
fun SettingScreen(
    navController: NavController,
    vm: SettingViewModel = koinViewModel(),
) {
    Scaffold(
        topBar = {
            Appbar(titleRes = R.string.lab_settings)
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .clickable {
                },
        ) {
            Text(text = "Hello Setting Screen")
        }
    }
}
