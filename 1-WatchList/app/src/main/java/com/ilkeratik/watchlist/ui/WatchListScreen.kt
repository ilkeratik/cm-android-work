package com.ilkeratik.watchlist.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ilkeratik.watchlist.viewmodel.WatchItemViewModel

@Composable
fun WatchListScreen(
    watchItemViewModel: WatchItemViewModel = viewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "Watch List",
                style = MaterialTheme.typography.labelLarge,
                fontSize = 24.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
            )
            WatchItemsList(
                list = watchItemViewModel.watchItems,
                onChecked = { item, checked ->
                    watchItemViewModel.changeTaskChecked(item, checked)
                },
                onExpandChange = { item, expand ->
                    watchItemViewModel.changeTaskExpand(item, expand)
                },
                onDelete = { item -> watchItemViewModel.remove(item) },
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
            )
        }
        StatefulAddWatchItem(
            onSave = { newItem ->
                watchItemViewModel.add(newItem)
            }
        )
    }
}

