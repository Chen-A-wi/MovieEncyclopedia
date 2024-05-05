package com.awilab.movieencyclopedia.ui.widgets.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Stream
import androidx.compose.material.icons.outlined.Movie
import androidx.compose.material.icons.outlined.Stream
import androidx.compose.ui.graphics.vector.ImageVector
import com.awilab.movieencyclopedia.R
import com.ramcosta.composedestinations.generated.destinations.MovieScreenDestination
import com.ramcosta.composedestinations.generated.destinations.SteamScreenDestination
import com.ramcosta.composedestinations.spec.DirectionDestinationSpec

// See more: https://github.com/shahbaz213/JetPackBottomNavigation

internal sealed class NavItem(
    @StringRes var title: Int,
    var selectedIcon: ImageVector,
    var unselectedIcon: ImageVector,
    val direction: DirectionDestinationSpec
) {

    data object Movie : NavItem(
        title = R.string.nav_movie_title,
        selectedIcon = Icons.Filled.Movie,
        unselectedIcon = Icons.Outlined.Movie,
        direction = MovieScreenDestination,
    )

    data object Stream : NavItem(
        title = R.string.nav_stream_title,
        selectedIcon = Icons.Filled.Stream,
        unselectedIcon = Icons.Outlined.Stream,
        direction = SteamScreenDestination,
    )
}
