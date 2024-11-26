package com.ilkeratik.watchlist.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ilkeratik.watchlist.data.WellnessTasksList
import com.ilkeratik.watchlist.viewmodel.WellnessViewModel

@Composable
fun WellnessScreen(modifier: Modifier = Modifier,
                   wellnessViewModel: WellnessViewModel = viewModel()) {
    var showError by rememberSaveable { mutableStateOf(false) }
    Column(modifier = modifier) {
        StatefulAddTask(onSave = { newTask ->
            if(newTask.label.isNotEmpty()){
                wellnessViewModel.add(newTask)
                showError = false
            } else{
                showError = true
            } },
            showSnackBar = showError)
        WellnessTasksList(list = wellnessViewModel.tasks,
            onCheckedTask = { task, checked ->
                wellnessViewModel.changeTaskChecked(task, checked)
            },
            onCloseTask = { task -> wellnessViewModel.remove(task) })
    }
}

