package com.project.whypark.ui.component.button.social

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.project.whypark.R

@Composable
fun SocialLoginButton(category: String) {
    Box(
        modifier = Modifier
            .width(40.dp)
            .height(40.dp)
    ) {
        if (category == "google") {
            Icon(
                painter = painterResource(R.drawable.google_icon),
                contentDescription = "Google Icon",
                tint = Color.Unspecified
            )
        } else if (category == "kakao") {
            Icon(
                painter = painterResource(R.drawable.kakao_login),
                contentDescription = "Google Icon",
                tint = Color.Unspecified
            )
        }
    }
}