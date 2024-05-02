package com.awilab.movieencyclopedia.ui.setting

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.awilab.movieencyclopedia.ui.theme.MovieEncyclopediaTheme

@Composable
fun ItemCard(itemData: ItemData, onItemClick: (data: ItemData) -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onItemClick.invoke(itemData)
                    },
            ) {
                Text(text = itemData.itemTitle, modifier = Modifier.padding(8.dp))
            }
            HorizontalDivider(color = Color.Black)
        }
    }
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true, name = "Light mode")
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "Dark mode")
fun ItemCardPreview() {
    MovieEncyclopediaTheme {
        ItemCard(itemData = ItemData("Test", "cc")) {
        }
    }
}
