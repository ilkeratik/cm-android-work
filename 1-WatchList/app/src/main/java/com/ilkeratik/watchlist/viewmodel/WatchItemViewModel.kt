package com.ilkeratik.watchlist.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.ilkeratik.watchlist.ui.WatchItemModel

class WatchItemViewModel : ViewModel() {
    private val _watchItems = mutableStateListOf<WatchItemModel>().apply {
        addAll(List(2) { i ->
            WatchItemModel(
                "${i + 1}",
                "Watch Item Name # ${i + 1}",
                "Watch Item Description # ${i + 1}"
            )
        })
    }
    val watchItems: List<WatchItemModel>
        get() = _watchItems

    fun remove(item: WatchItemModel) {
        _watchItems.remove(item)
    }

    fun add(item: WatchItemModel) {
        _watchItems.add(item)
    }

    fun changeTaskChecked(item: WatchItemModel, checked: Boolean) =
        _watchItems.find { it.id == item.id }?.let { task ->
            task.checked.value = checked
        }

    fun changeTaskExpand(item: WatchItemModel, expand: Boolean) =
        _watchItems.find { it.id == item.id }?.let { task ->
            task.expand.value = expand
        }

}