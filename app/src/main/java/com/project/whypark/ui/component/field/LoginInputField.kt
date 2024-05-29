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
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.MutableLiveData
import com.project.parks_datasource.viewmodel.LoginViewModel
import kotlinx.coroutines.flow.StateFlow
import java.lang.NullPointerException

@Composable
fun LoginInputField(
    maxLength: Int,
    loginViewModel: LoginViewModel,
    status: String,
    setTextState: @Composable (StateFlow<String>) -> Unit,
) {

    val emailState = loginViewModel.emailFlow.collectAsState()
    val passwordState = loginViewModel.passwordFlow.collectAsState()

    TextField (
        modifier = Modifier.fillMaxWidth(),
        value = if (status == "email") emailState.value else passwordState.value,
        onValueChange = { state ->
            if (state.length <= maxLength) {

                if (status == "email") {
                    loginViewModel.emailUsers(state)
                }

                if (status == "password") {
                    loginViewModel.passwordUsers(state)
                }
            }
        },
        shape = RoundedCornerShape(8.dp),
        singleLine = false,
        trailingIcon = {
            IconButton(onClick = { if (status == "email") loginViewModel.clearEmail() else loginViewModel.clearPassword() }) {
                Icon (
                    imageVector = Icons.Outlined.Close,
                    contentDescription = null
                )
            }
        }
    )

    if (status == "email") {
        setTextState(loginViewModel.emailFlow)
    } else {
        setTextState(loginViewModel.passwordFlow)
    }
}