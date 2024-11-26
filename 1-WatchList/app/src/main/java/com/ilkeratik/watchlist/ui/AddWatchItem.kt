package com.ilkeratik.watchlist.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ilkeratik.watchlist.data.WatchItem

@Composable
fun StatefulAddWatchItem(onSave:  (WatchItem) -> Unit, modifier: Modifier = Modifier,showSnackBar: Boolean = false ) {
    var value by rememberSaveable { mutableStateOf("") }
    if(showSnackBar){
        Snackbar(containerColor = Color.LightGray, modifier = Modifier
            .clip(RoundedCornerShape(30.dp))
            .padding(5.dp)) {
            Text(text = "Watch list label cannot be empty", color = Color(0xFFB00020), fontWeight = FontWeight.Bold)
        }
    }
    StatelessAddWatchItem(value, { wax-> value=wax }, onSave, modifier)
}

@Composable
fun StatelessAddWatchItem(input: String, onInputChange: (String) -> Unit, onSave: (WatchItem)-> Unit, modifier: Modifier = Modifier) {

    Row (
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth(),
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
        horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceBetween) {
        OutlinedTextField(
            singleLine = true,
            label = { Text("Enter Watch Item") },
            value = input,
            onValueChange = { vax -> onInputChange(vax) },
        )
        Button (onClick = {onSave(WatchItem(input,input)); onInputChange("")}) {
            Text("+", fontSize = 30.sp)
        }
    }
}