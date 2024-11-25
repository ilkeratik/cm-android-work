package com.ilkeratik.watchlist.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun StatefulAddTask(onSave: (WellnessTask) -> Unit, modifier: Modifier = Modifier) {
    var value by rememberSaveable { mutableStateOf("") }
    StatelessAddTask(value, { wax-> value=wax }, onSave, modifier)
}

@Composable
fun StatelessAddTask(input: String, onInputChange: (String) -> Unit, onSave: (WellnessTask)-> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        OutlinedTextField(
            maxLines = 1,
            label = { Text("Enter Task") },
            value = input,
            onValueChange = { vax -> onInputChange(vax) },
        )
        Button(onClick = {onSave(WellnessTask(12,input))}, Modifier.padding(top = 8.dp)) {
            Text("Add new task")
        }
    }
}