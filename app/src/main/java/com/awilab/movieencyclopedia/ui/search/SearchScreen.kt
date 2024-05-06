package com.awilab.movieencyclopedia.ui.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    var text by rememberSaveable { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.fillMaxWidth(),
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Green.copy(alpha = 0.3f),
                ),
                title = {
//                    OutlinedTextField(
//                        value = text,
//                        onValueChange = { text = it },
//                        label = { Text("Search") },
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(8.dp),
//                        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
//                        keyboardActions = KeyboardActions(onSearch = {  }),
//                        shape = MaterialTheme.shapes.large,
//                        leadingIcon = {
//                            Icon(
//                                imageVector = Icons.Filled.Search,
//                                contentDescription = "Search Icon"
//                            )
//                        },
//                    )
                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp),
                        value = text,
                        onValueChange = { text = it },
                        placeholder = { Text(text = stringResource(id = R.string.nav_search_title)) },
                        singleLine = true,
                        leadingIcon = { Icon(Icons.Filled.Search, contentDescription = "Localized description") },
                        trailingIcon = { Icon(Icons.Filled.Cancel, contentDescription = "Localized description") },
                        colors = TextFieldDefaults.colors(
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                        ),
                    )
                },
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .clickable {
                },
        ) {
            Text(text = "Hello Search Screen")
        }
    }
}
