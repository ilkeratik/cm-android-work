package com.ilkeratik.watchlist.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun StatefulAddWatchItem(
    onSave: (WatchItemModel) -> Unit,
) {
    var name by rememberSaveable { mutableStateOf("") }
    var description by rememberSaveable { mutableStateOf("") }
    var showSnackBar by rememberSaveable { mutableStateOf(false) }
    var expandFields by rememberSaveable { mutableStateOf(false) }

    if (showSnackBar) {
        Snackbar(
            containerColor = Color.LightGray, modifier = Modifier
                .clip(RoundedCornerShape(30.dp))
                .padding(5.dp)
        ) {
            Text(
                text = "Watch list name cannot be empty!",
                color = Color(0xFFB00020),
                fontWeight = FontWeight.Bold
            )
        }
    }
    StatelessAddWatchItem(
        name,
        { n -> name = n },
        description,
        { d -> description = d },
        onSave = {
            if (!expandFields) {
                expandFields = true
            } else if (it.name.isNotEmpty()) {
                onSave(it)
                expandFields = false
            } else {
                showSnackBar = true
            }
        },
        expandFields = expandFields
    )
}

@Composable
fun StatelessAddWatchItem(
    name: String,
    onNameInputChange: (String) -> Unit,
    description: String,
    onDescriptionInputChange: (String) -> Unit,
    onSave: (WatchItemModel) -> Unit,
    expandFields: Boolean
) {
    Row(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier.padding(start = 5.dp, end = 5.dp)
        ) {
            if (expandFields) {
                OutlinedTextField(
                    singleLine = true,
                    label = { Text("Enter Name") },
                    value = name,
                    onValueChange = { n -> onNameInputChange(n) },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    maxLines = 3,
                    label = { Text("Enter Description") },
                    value = description,
                    onValueChange = { d -> onDescriptionInputChange(d) },
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Button(
                onClick = {
                    onSave(
                        WatchItemModel(
                            name,
                            name,
                            description
                        )
                    )
                    onNameInputChange("")
                    onDescriptionInputChange("")
                },
                modifier = if (expandFields) {
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                } else {
                    Modifier.padding(top = 5.dp)
                }
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add", Modifier.size(32.dp))
            }
        }

    }
}