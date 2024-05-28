package com.project.whypark.ui.component.field

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LoginInputField(textState: MutableState<String>, maxLength: Int, setTextState: @Composable (MutableState<String>) -> Unit) {
    TextField (
        modifier = Modifier.fillMaxWidth(),
        value = textState.value,
        onValueChange = {
            if (it.length <= maxLength) {
                textState.value = it
            }
        },
        shape = RoundedCornerShape(8.dp),
        singleLine = false,
        trailingIcon = {
            if (textState.value.isNotEmpty()) {
                IconButton(onClick = { textState.value = "" }) {
                    Icon (
                        imageVector = Icons.Outlined.Close,
                        contentDescription = null
                    )
                }
            }
        }
    )

    setTextState(textState)
}