package com.project.parks_datasource.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.parks_domain.entity.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class LoginViewModel : ViewModel() {

    private val _emailFlow = MutableStateFlow("")
    private val _passwordFlow = MutableStateFlow("")

    val emailFlow: StateFlow<String> get() = _emailFlow
    val passwordFlow: StateFlow<String> get() = _passwordFlow

    fun emailUsers(email: String) {
        if (email.isNotEmpty()) {
            _emailFlow.value = email
        }
    }

    fun passwordUsers(password: String) {
        if (password.isNotEmpty()) {
            _passwordFlow.value = password
        }
    }

    fun clearEmail() {
        _emailFlow.value = ""
    }

    fun clearPassword() {
        _passwordFlow.value = ""
    }
}