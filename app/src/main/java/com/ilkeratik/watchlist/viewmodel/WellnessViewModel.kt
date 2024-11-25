package com.ilkeratik.watchlist.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.ilkeratik.watchlist.ui.WellnessTask

class WellnessViewModel : ViewModel() {
    private val _tasks = mutableStateListOf<WellnessTask>().apply { addAll(List(2) { i -> WellnessTask(i, "Task # ${i+1}") } ) }
    val tasks: List<WellnessTask>
        get() = _tasks

    fun remove(item: WellnessTask) {
        _tasks.remove(item)
    }

    fun add(item: WellnessTask) {
        _tasks.add(item)
    }
}