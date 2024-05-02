package com.awilab.movieencyclopedia.ui.widgets.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Stream
import androidx.compose.ui.graphics.vector.ImageVector
import com.awilab.movieencyclopedia.R

// See more: https://github.com/shahbaz213/JetPackBottomNavigation

internal sealed class NavItem(var selectedIcon: ImageVector, @StringRes var title: Int) {
    data object Movie : NavItem(
        selectedIcon = Icons.Filled.Movie,
        title = R.string.nav_movie_title,
    )

    data object Streaming : NavItem(
        selectedIcon = Icons.Filled.Stream,
        title = R.string.nav_stream_title,
    )

    data object Search : NavItem(
        selectedIcon = Icons.Filled.Search,
        title = R.string.nav_search_title,
    )

    data object Setting : NavItem(
        selectedIcon = Icons.Filled.Settings,
        title = R.string.nav_setting_title,
    )
}
