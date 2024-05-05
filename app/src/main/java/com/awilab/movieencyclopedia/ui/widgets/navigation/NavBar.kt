package com.awilab.movieencyclopedia.ui.widgets.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.ramcosta.composedestinations.navigation.navigate

internal val navList = listOf(
    NavItem.Movie,
    NavItem.Stream,
)

@Composable
fun NavBar(
    navController: NavController
) {
    var selectIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    NavigationBar {
        navList.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectIndex == index,
                onClick = {
                    selectIndex = index
                    navController.navigate(item.direction) {
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = if (index == selectIndex) {
                            item.selectedIcon
                        } else {
                            item.unselectedIcon
                        },
                        contentDescription = stringResource(id = item.title)
                    )
                },
            )
        }
    }
}