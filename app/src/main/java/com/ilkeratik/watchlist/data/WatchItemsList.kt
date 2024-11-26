package com.ilkeratik.watchlist.data

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier

class WatchItem(val id: String, val label: String, val checked: MutableState<Boolean> = mutableStateOf(false))


@Composable
fun WatchItemsList(
    modifier: Modifier = Modifier,
    list: List<WatchItem> = emptyList(),
    onChecked: (WatchItem, Boolean) -> Unit,
    onClose: (WatchItem) -> Unit
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(list) { task ->
            WatchItem(
                taskName = task.label,
                checked = task.checked,
                onCheckedChange = { checked -> onChecked(task, checked) },
                onClose = { onClose(task) })
        }
    }
}