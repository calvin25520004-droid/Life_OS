package com.example.lifeos.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Pastikan BluePrimary, BlueLight, GrayText, dan BackgroundLight
// sudah didefinisikan di file Color.kt dalam package yang sama
private val DarkColorScheme = darkColorScheme(
    primary = BluePrimary,
    secondary = BlueLight,
    tertiary = GrayText,
    background = Color(0xFF121212),
    surface = Color(0xFF121212)
)

private val LightColorScheme = lightColorScheme(
    primary = BluePrimary,
    secondary = BlueLight,
    tertiary = GrayText,
    background = BackgroundLight,
    surface = Color.White
)

@Composable
fun LifeOSTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography, // Jika Typography merah, tekan Alt+Enter untuk import
        content = content
    )
}