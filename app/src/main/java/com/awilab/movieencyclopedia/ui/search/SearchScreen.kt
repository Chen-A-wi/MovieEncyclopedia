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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.awilab.movieencyclopedia.R
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootGraph
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Destination<RootGraph>()
@Composable
fun SearchScreen(
    navController: NavController,
    vm: SearchViewModel = koinViewModel(),
) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
        ) {
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colorScheme.primary),
            ) {
                SearchField(
                    keyword = vm.keywordStateFlow.collectAsState(initial = "").value,
                    onValueChange = vm::onSearch,
                    onClear = vm::onClear,
                )
            }

            Text(text = "Hello Search Screen")
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
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp).fillMaxWidth(),
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
        supportingText = { Text(text = "Supporting text") },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = MaterialTheme.colorScheme.outlineVariant,
            unfocusedBorderColor = MaterialTheme.colorScheme.outline,
            focusedLabelColor = MaterialTheme.colorScheme.outlineVariant,
            unfocusedLabelColor = MaterialTheme.colorScheme.outline,
            cursorColor = MaterialTheme.colorScheme.outline,
        ),
    )
}
