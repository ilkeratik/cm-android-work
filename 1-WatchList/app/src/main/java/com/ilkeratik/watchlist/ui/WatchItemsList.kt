package com.ilkeratik.watchlist.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import com.ilkeratik.watchlist.ui.theme.WatchItem

class WatchItemModel(
    val id: String,
    val name: String,
    val description: String,
    val checked: MutableState<Boolean> = mutableStateOf(false),
    val expand: MutableState<Boolean> = mutableStateOf(false)
)


@Composable
fun WatchItemsList(
    modifier: Modifier = Modifier,
    list: List<WatchItemModel> = emptyList(),
    onChecked: (WatchItemModel, Boolean) -> Unit,
    onDelete: (WatchItemModel) -> Unit,
    onExpandChange: (WatchItemModel, Boolean) -> Unit,
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(list) { task ->
            WatchItem(
                name = task.name,
                checked = task.checked,
                expandItem = task.expand,
                description = task.description,
                onDelete = { onDelete(task) },
                onCheckedChange = { onChecked(task, it) },
                onExpandChange = { onExpandChange(task, it) },
            )
        }
    }
}