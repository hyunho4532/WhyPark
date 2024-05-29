package com.project.whypark.ui.component.button

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.project.parks_datasource.viewmodel.LoginViewModel

@Composable
fun LoginButton(loginViewModel: LoginViewModel) {
    OutlinedButton (
        modifier = Modifier
            .width(160.dp)
            .height(120.dp)
            .padding(top = 80.dp),

        onClick = {

    }) {
        Text(text = "다음 화면으로")
    }
}