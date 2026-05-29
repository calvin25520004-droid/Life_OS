package com.example.lifeos

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.biometric.BiometricPrompt
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import com.example.lifeos.ui.theme.LifeOSTheme
import com.example.lifeos.ui.theme.Login.LoginScreen
import com.example.lifeos.ui.theme.Login.LoginViewModel
import com.example.lifeos.ui.theme.MainContainer


class MainActivity : FragmentActivity() {

    // Inisialisasi ViewModel
    private val viewModel: LoginViewModel by viewModels()

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        setContent {
//        // 1. Panggil Tema Aplikasi
//        }
//            LifeOSTheme {
//                // 2. Panggil Screen yang ingin ditampilkan
//                LoginScreen(
//                    viewModel = viewModel,
//                    onLoginClick = {
//                        Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show()
//                    },
//                    onBiometricClick = { promptBiometric() }
//                )
//            }
//        }
//    }




//   override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            LifeOSTheme {
//                // Setelah Login Berhasil, arahkan ke MainContainer
//                MainContainer()
//            }
//        }
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LifeOSTheme {
                // State untuk mengontrol halaman mana yang muncul
                var isLoggedIn by remember { mutableStateOf(false) }

                if (!isLoggedIn) {
                    // Tampilkan Page Login terlebih dahulu
                    LoginScreen(
                        viewModel = viewModel,
                        onLoginClick = { isLoggedIn = true }, // Pindah ke beranda saat klik login
                        onBiometricClick = { promptBiometric { isLoggedIn = true } }
                    )
                } else {
                    // Jika sudah login, baru tampilkan Beranda & Bottom Bar
                    MainContainer()
                }
            }
        }
    }

    private fun promptBiometric(onSuccess: () -> Unit) {
        val executor = ContextCompat.getMainExecutor(this)
        val biometricPrompt = BiometricPrompt(this, executor,
            object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    super.onAuthenticationSucceeded(result)
                    onSuccess() // Jalankan fungsi sukses
                }
            })

        val promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("Login Biometrik")
            .setNegativeButtonText("Batal")
            .build()

        biometricPrompt.authenticate(promptInfo)
    }
}


// private fun promptBiometric() {
//        val executor = ContextCompat.getMainExecutor(this)
//        val biometricPrompt = BiometricPrompt(this, executor,
//            object : BiometricPrompt.AuthenticationCallback() {
//                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
//                    super.onAuthenticationSucceeded(result)
//                    Toast.makeText(this@MainActivity, "Biometric Berhasil!", Toast.LENGTH_SHORT).show()
//                }
//            })
//
//        val promptInfo = BiometricPrompt.PromptInfo.Builder()
//            .setTitle("Login Biometrik")
//            .setNegativeButtonText("Batal")
//            .build()
//
//        biometricPrompt.authenticate(promptInfo)
//    }
//}