package com.awilab.movieencyclopedia.ui.setting

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootGraph

data class ItemData(
    val itemTitle: String,
    val wifiConfigInfo: String,
)

val wifiConfigs = listOf(
    ItemData(
        itemTitle = "WPA/WPA2-Enterprise(System CA)",
        wifiConfigInfo = "aa",
    ),
    ItemData(
        itemTitle = "WPA/WPA2-Enterprise(Customized CA)",
        wifiConfigInfo = "bb",
    ),
)

@Destination<RootGraph>(route = "SettingRoute")
@Composable
fun SettingScreen(
    paddingModifier: Modifier,
    dataList: List<ItemData>,
) {
    Column(
        modifier = paddingModifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface),
    ) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = paddingModifier
                .fillMaxSize()
                .padding(bottom = 40.dp),
        ) {
            items(dataList.size) { index ->
                ItemCard(
                    itemData = ItemData(
                        itemTitle = dataList[index].itemTitle,
                        wifiConfigInfo = "",
                    ),
                    onItemClick = {},
                )
            }
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
            modifier = paddingModifier.height(20.dp)
                .fillMaxWidth(),
        ) {
            Text(text = "Version")
            Text(text = "1.0")
        }
    }
}
