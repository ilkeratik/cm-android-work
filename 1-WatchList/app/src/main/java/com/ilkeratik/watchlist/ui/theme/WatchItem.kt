package com.ilkeratik.watchlist.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.twotone.PlayArrow
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun WatchItem(
    name: String,
    description: String,
    expandItem: MutableState<Boolean>,
    checked: MutableState<Boolean>,
    onCheckedChange: (Boolean) -> Unit,
    onDelete: () -> Unit,
    onExpandChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(5.dp)
            .border(BorderStroke(1.dp, color = Color.Gray))
            .padding(0.dp, 5.dp)
            .clickable { onExpandChange(!expandItem.value) },
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onDelete) {
                Icon(
                    Icons.TwoTone.PlayArrow,
                    contentDescription = "Video",
                    modifier = Modifier.size(48.dp),
                    tint = Color(0xFFB00020)
                )
            }
            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp),
                text = name
            )
            Checkbox(
                checked = checked.value,
                onCheckedChange = onCheckedChange
            )
            IconButton(onClick = onDelete) {
                Icon(Icons.Filled.Close, contentDescription = "Delete")
            }
        }
        if (expandItem.value) {
            Text(
                text = description,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}