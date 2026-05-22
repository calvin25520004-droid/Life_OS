package com.example.lifeos

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import com.example.lifeos.ui.theme.LifeOSTheme
import com.example.lifeos.ui.theme.Login.LoginScreen
import com.example.lifeos.ui.theme.Login.LoginViewModel


class MainActivity : FragmentActivity() {

    // Inisialisasi ViewModel
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            // 1. Panggil Tema Aplikasi
            LifeOSTheme {
                // 2. Panggil Screen yang ingin ditampilkan
                LoginScreen(
                    viewModel = viewModel,
                    onLoginClick = {
                        Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show()
                    },
                    onBiometricClick = { promptBiometric() }
                )
            }
        }
    }

    private fun promptBiometric() {
        val executor = ContextCompat.getMainExecutor(this)
        val biometricPrompt = BiometricPrompt(this, executor,
            object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    super.onAuthenticationSucceeded(result)
                    Toast.makeText(this@MainActivity, "Biometric Berhasil!", Toast.LENGTH_SHORT).show()
                }
            })

        val promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("Login Biometrik")
            .setNegativeButtonText("Batal")
            .build()

        biometricPrompt.authenticate(promptInfo)
    }
}