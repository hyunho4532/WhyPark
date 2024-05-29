package com.project.whypark

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.parks_datasource.viewmodel.LoginViewModel
import com.project.whypark.ui.component.form.LoginForm
import com.project.whypark.ui.theme.WhyParkTheme

class LoginActivity : ComponentActivity() {

    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WhyParkTheme {
                Column (
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    
                    Text (
                        text = "안녕하세요.\n와이 파크에 오신것을 환영합니다.",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                    
                    Spacer (
                        modifier = Modifier.padding(top = 80.dp)
                    )
                    
                    LoginForm (
                        loginViewModel = loginViewModel
                    )
                }
            }
        }
    }
}