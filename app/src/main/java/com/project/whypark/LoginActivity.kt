package com.project.whypark

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.parks_datasource.viewmodel.LoginViewModel
import com.project.whypark.ui.component.button.LoginButton
import com.project.whypark.ui.component.button.social.SocialLoginButton
import com.project.whypark.ui.component.form.LoginForm
import com.project.whypark.ui.theme.WhyParkTheme

class LoginActivity : ComponentActivity() {

    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WhyParkTheme {

                Text (
                    text = "안녕하세요.\n와이 파크에 오신것을 환영합니다.",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(16.dp)
                )

                Text (
                    text = "영화 목록, 영화 추천, 근처 영화관 조회 등 다양한 기능을 구현하고 있어요!",
                    fontSize = 11.sp,
                    modifier = Modifier
                        .padding(top = 80.dp, start = 16.dp)
                )

                Column (
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Spacer(
                        modifier = Modifier.padding(top = 150.dp)
                    )

                    LoginForm(
                        loginViewModel = loginViewModel
                    )

                    Spacer (
                        modifier = Modifier.padding(top = 50.dp)
                    )

                    Text (
                        text =  "------- 간편 로그인을 이용하여 로그인을 진행하기 -------",
                        fontSize = 14.sp
                    )

                    Spacer (
                        modifier = Modifier.padding(top = 30.dp)
                    )

                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        SocialLoginButton("google")
                        Spacer(modifier = Modifier.width(80.dp))
                        SocialLoginButton("kakao")
                    }

                    Spacer(
                        modifier = Modifier.padding(top = 20.dp)
                    )

                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End,
                    ) {
                        LoginButton(
                            loginViewModel = loginViewModel
                        )
                    }
                }
            }
        }
    }
}
