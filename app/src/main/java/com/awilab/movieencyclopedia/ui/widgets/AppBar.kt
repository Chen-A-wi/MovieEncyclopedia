@file:OptIn(ExperimentalMaterial3Api::class)

package com.awilab.movieencyclopedia.ui.widgets

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@StringRes
@Composable
@SuppressLint("SupportAnnotationUsage")
fun Appbar(titleRes: Int) {
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp),
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
        ),
        title = {
            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
                Text(
                    text = stringResource(id = titleRes),
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                )
            }
        },
    )
}
