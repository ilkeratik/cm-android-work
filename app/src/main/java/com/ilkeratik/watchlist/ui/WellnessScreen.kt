package com.ilkeratik.watchlist.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier

@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {
    val tasks = List(2) { i -> WellnessTask(i, "Task # ${i+1}") } .toMutableStateList()

    Column(modifier = modifier) {
        StatefulAddTask(onSave = { newTask -> tasks.add(newTask) })
        WellnessTasksList(list = tasks, onCloseTask = { task -> tasks.remove(task) })
    }

}

