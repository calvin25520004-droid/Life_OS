package com.example.lifeos.ui.theme.Login


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Tambahkan import warna secara spesifik atau gunakan .*
import com.example.lifeos.ui.theme.BluePrimary
import com.example.lifeos.ui.theme.BlueLight
import com.example.lifeos.ui.theme.GrayText
import com.example.lifeos.ui.theme.BackgroundLight


@Composable
fun LoginScreen(
    viewModel: LoginViewModel,
    onLoginClick: () -> Unit,
    onBiometricClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundLight)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(64.dp))

        // Logo Section
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(BluePrimary, RoundedCornerShape(20.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(Icons.Default.Shield, contentDescription = null, tint = Color.White, modifier = Modifier.size(40.dp))
        }

        Text(
            text = "Welcome back",
            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(text = "Please enter your details to sign in", color = GrayText)

        Spacer(modifier = Modifier.height(40.dp))

        // Input Fields
        OutlinedTextField(
            value = viewModel.email,
            onValueChange = { viewModel.onEmailChange(it) },
            label = { Text("Email or Username") },
            placeholder = { Text("name@company.com") },
            leadingIcon = { Icon(Icons.Default.AlternateEmail, null, tint = BluePrimary) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = viewModel.password,
            onValueChange = { viewModel.onPasswordChange(it) },
            label = { Text("Password") },
            leadingIcon = { Icon(Icons.Default.Lock, null, tint = BluePrimary) },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        )

        // Login Button
        Button(
            onClick = onLoginClick,
            enabled = viewModel.isLoginEnabled,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp)
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(containerColor = BluePrimary),
            shape = RoundedCornerShape(28.dp)
        ) {
            Text("Login →", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.weight(1f))

        // Biometric Section
        Text("Or sign in with biometrics", color = GrayText)
        Spacer(modifier = Modifier.height(16.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(24.dp)) {
//            BiometricCircleButton(icon = Icons.Default.Face, onClick = onBiometricClick)
            BiometricCircleButton(icon = Icons.Default.Fingerprint, onClick = onBiometricClick)
        }

        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Composable
fun BiometricCircleButton(icon: ImageVector, onClick: () -> Unit) {
    IconButton(
        onClick = onClick,
        modifier = Modifier
            .size(64.dp)
            .background(BlueLight, CircleShape)
    ) {
        Icon(icon, contentDescription = null, tint = BluePrimary, modifier = Modifier.size(32.dp))
    }
}
