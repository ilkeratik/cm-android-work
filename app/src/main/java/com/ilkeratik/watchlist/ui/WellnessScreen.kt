package com.ilkeratik.watchlist.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ilkeratik.watchlist.viewmodel.WellnessViewModel

@Composable
fun WellnessScreen(modifier: Modifier = Modifier,
                   wellnessViewModel: WellnessViewModel = viewModel()) {
    Column(modifier = modifier) {
        StatefulAddTask(onSave = { newTask -> wellnessViewModel.add(newTask) })
        WellnessTasksList(list = wellnessViewModel.tasks, onCloseTask = { task -> wellnessViewModel.remove(task) })
    }
}

