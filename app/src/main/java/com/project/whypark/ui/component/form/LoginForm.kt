package com.project.whypark.ui.component.form

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.project.parks_datasource.viewmodel.LoginViewModel
import com.project.whypark.ui.component.field.LoginInputField

@Composable
fun LoginForm(loginViewModel: LoginViewModel) {

    val maxLength = 22
    val blue = Color(0xff76a9ff)

    Text (
        text = "이메일을 입력해주세요!",
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 4.dp),
        textAlign = TextAlign.Start,
        color = Color.Black
    )


    LoginInputField (
        maxLength = maxLength,
        loginViewModel = loginViewModel,
        status = "email"
    ) { state ->
        Text (
            text = "${state.collectAsState().value.length} / $maxLength",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            textAlign = TextAlign.End,
            color = blue
        )
    }


    Spacer (
        modifier = Modifier.padding(top = 60.dp)
    )


    Text (
        text = "비밀번호를 입력해주세요!",
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 4.dp),
        textAlign = TextAlign.Start,
        color = Color.Black
    )


    LoginInputField (
        maxLength = maxLength,
        loginViewModel = loginViewModel,
        status = "password"
    )
    { state ->
        Text (
            text = "${state.collectAsState().value.length} / $maxLength",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            textAlign = TextAlign.End,
            color = blue
        )
    }
}