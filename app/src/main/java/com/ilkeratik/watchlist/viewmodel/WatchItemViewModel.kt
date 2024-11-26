package com.ilkeratik.watchlist.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.ilkeratik.watchlist.data.WatchItem

class WatchItemViewModel : ViewModel() {
    private val _watchItems = mutableStateListOf<WatchItem>().apply { addAll(List(2) { i -> WatchItem("${i+1}", "Watch Item # ${i+1}") } ) }
    val watchItems: List<WatchItem>
        get() = _watchItems

    fun remove(item: WatchItem) {
        _watchItems.remove(item)
    }

    fun add(item: WatchItem) {
        _watchItems.add(item)
    }
    fun changeTaskChecked(item: WatchItem, checked: Boolean) =
        _watchItems.find { it.id == item.id }?.let { task ->
            task.checked.value = checked
        }
}