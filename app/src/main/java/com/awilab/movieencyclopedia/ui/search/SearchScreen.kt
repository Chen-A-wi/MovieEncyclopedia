package com.awilab.movieencyclopedia.ui.search

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.awilab.domain.model.movie.Movie
import com.awilab.movieencyclopedia.R
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootGraph
import org.koin.androidx.compose.koinViewModel

@Destination<RootGraph>()
@Composable
fun SearchScreen(
    navController: NavController,
    vm: SearchViewModel = koinViewModel(),
) {
    val searchUiStatus by vm.uiState.collectAsState()

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
        ) {
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colorScheme.secondaryContainer),
            ) {
                SearchField(
                    keyword = vm.keywordStateFlow.collectAsState(initial = "").value,
                    onValueChange = vm::onSearch,
                    onClear = vm::onClear,
                )
            }

            ListContent(
                modifier = Modifier.padding(innerPadding),
                listData = searchUiStatus.movieList,
            )
        }
    }
}

@Composable
fun SearchField(
    keyword: String,
    onValueChange: (keyword: String) -> Unit,
    onClear: () -> Unit,
) {
    OutlinedTextField(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
            .fillMaxWidth(),
        shape = MaterialTheme.shapes.extraLarge,
        value = keyword,
        onValueChange = onValueChange,
        singleLine = true,
        label = { Text(text = stringResource(id = R.string.lab_search)) },
        leadingIcon = {
            Icon(
                Icons.Filled.Search,
                tint = MaterialTheme.colorScheme.outline,
                contentDescription = stringResource(id = R.string.lab_search),
            )
        },
        trailingIcon = {
            AnimatedVisibility(
                visible = keyword.isNotBlank(),
                enter = fadeIn() + scaleIn(),
                exit = fadeOut() + scaleOut(),
            ) {
                IconButton(
                    onClick = onClear,
                ) {
                    Icon(
                        Icons.Filled.Clear,
                        tint = MaterialTheme.colorScheme.outline,
                        contentDescription = stringResource(id = R.string.lab_clear),
                    )
                }
            }
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = MaterialTheme.colorScheme.onSecondaryContainer,
            unfocusedBorderColor = MaterialTheme.colorScheme.outline,
            focusedLabelColor = MaterialTheme.colorScheme.onSecondaryContainer,
            unfocusedLabelColor = MaterialTheme.colorScheme.outline,
            cursorColor = MaterialTheme.colorScheme.onSecondaryContainer,
        ),
    )
}

@Composable
fun ListContent(modifier: Modifier, listData: List<Movie>) {
    LazyColumn(
        modifier = modifier,
    ) {
        items(listData) { movie ->
            MovieItem(modifier, movie)
        }
    }
}
