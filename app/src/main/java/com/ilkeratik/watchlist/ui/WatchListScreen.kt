package com.ilkeratik.watchlist.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ilkeratik.watchlist.data.WatchItemsList
import com.ilkeratik.watchlist.viewmodel.WatchItemViewModel

@Composable
fun WellnessScreen(modifier: Modifier = Modifier,
                   watchItemViewModel: WatchItemViewModel = viewModel()) {
    var showError by rememberSaveable { mutableStateOf(false) }
    Column(modifier = modifier) {
        StatefulAddWatchItem(onSave = { newItem ->
            if(newItem.label.isNotEmpty()){
                watchItemViewModel.add(newItem)
                showError = false
            } else{
                showError = true
            } },
            showSnackBar = showError)
        WatchItemsList(list = watchItemViewModel.watchItems,
            onChecked = { watch, checked ->
                watchItemViewModel.changeTaskChecked(watch, checked)
            },
            onClose = { task -> watchItemViewModel.remove(task) })
    }
}

