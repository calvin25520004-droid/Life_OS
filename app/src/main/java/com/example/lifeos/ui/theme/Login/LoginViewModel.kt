package com.example.lifeos.ui.theme.Login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var isLoginEnabled by mutableStateOf(false)

    fun onEmailChange(newValue: String) {
        email = newValue
        validate()
    }

    fun onPasswordChange(newValue: String) {
        password = newValue
        validate()
    }

    private fun validate() {
        isLoginEnabled = email.contains("@") && password.length >= 6
    }
}