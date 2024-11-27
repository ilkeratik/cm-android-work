package com.ilkeratik.watchlist.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ilkeratik.watchlist.data.WatchItemsList
import com.ilkeratik.watchlist.viewmodel.WatchItemViewModel

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    watchItemViewModel: WatchItemViewModel = viewModel()
) {
    var showError by rememberSaveable { mutableStateOf(false) }
    Column(modifier = modifier) {
        StatefulAddWatchItem(
            onSave = { newItem ->
                if (newItem.label.isNotEmpty()) {
                    watchItemViewModel.add(newItem)
                    showError = false
                } else {
                    showError = true
                }
            },
            showSnackBar = showError
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Watch List",
            style = MaterialTheme.typography.labelLarge,
            fontSize = 24.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
        )
        WatchItemsList(list = watchItemViewModel.watchItems,
            onChecked = { watch, checked ->
                watchItemViewModel.changeTaskChecked(watch, checked)
            },
            onClose = { task -> watchItemViewModel.remove(task) })
    }
}

