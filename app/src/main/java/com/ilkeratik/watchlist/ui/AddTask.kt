package com.ilkeratik.watchlist.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.unit.sp
import com.ilkeratik.watchlist.data.WellnessTask

@Composable
fun StatefulAddTask(onSave: (WellnessTask) -> Unit, modifier: Modifier = Modifier) {
    var value by rememberSaveable { mutableStateOf("") }
    StatelessAddTask(value, { wax-> value=wax }, onSave, modifier)
}

@Composable
fun StatelessAddTask(input: String, onInputChange: (String) -> Unit, onSave: (WellnessTask)-> Unit, modifier: Modifier = Modifier) {
    Row (
        modifier = Modifier.padding( 5.dp).fillMaxWidth(),
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
        horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceBetween) {
        OutlinedTextField(
            singleLine = true,
            label = { Text("Enter Task") },
            value = input,
            onValueChange = { vax -> onInputChange(vax) },
        )
        Button (onClick = {onSave(WellnessTask(input,input)); onInputChange("")}) {
            Text("+", fontSize = 30.sp)
        }
    }
}