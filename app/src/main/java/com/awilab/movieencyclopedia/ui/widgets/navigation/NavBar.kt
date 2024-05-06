package com.awilab.movieencyclopedia.ui.widgets.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.ramcosta.composedestinations.generated.NavGraphs
import com.ramcosta.composedestinations.navigation.navigate
import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.utils.currentDestinationAsState
import com.ramcosta.composedestinations.utils.startDestination

internal val navList = listOf(
    NavItem.Movie,
    NavItem.Stream,
    NavItem.Search,
    NavItem.Setting,
)

// TODO: 需要修NavBar的Title沒有顯示
@Composable
fun NavBar(
    navController: NavController,
) {
    val currentDestination: DestinationSpec = navController.currentDestinationAsState().value
        ?: NavGraphs.root.startDestination

    NavigationBar {
        navList.forEach { item ->
            NavigationBarItem(
                selected = currentDestination == item.direction,
                onClick = {
                    navController.navigate(item.direction) {
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = if (item.direction == currentDestination) {
                            item.selectedIcon
                        } else {
                            item.unselectedIcon
                        },
                        contentDescription = stringResource(id = item.title),
                    )
                },
            )
        }
    }
}
