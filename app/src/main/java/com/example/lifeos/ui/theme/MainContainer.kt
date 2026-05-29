package com.example.lifeos.ui.theme

import Screen
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.lifeos.ui.theme.attendance.AttendanceScreen
import com.example.lifeos.ui.theme.finance.FinanceScreen
import com.example.lifeos.ui.theme.schedule.ScheduleScreen

@Composable
fun MainContainer() {
    var currentScreen by remember { mutableStateOf<Screen>(Screen.Finance) }

    Scaffold(
        bottomBar = {
            NavigationBar(containerColor = Color.White) {
                val items = listOf(Screen.Finance, Screen.Schedule, Screen.Attendance)
                items.forEach { screen ->
                    NavigationBarItem(
                        icon = { Icon(screen.icon, contentDescription = null) },
                        label = { Text(screen.title) },
                        selected = currentScreen == screen,
                        onClick = { currentScreen = screen },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color(0xFF00ADEF),
                            indicatorColor = Color(0xFFE1F5FE)
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when (currentScreen) {
                is Screen.Finance -> FinanceScreen()
                is Screen.Schedule -> ScheduleScreen()
                is Screen.Attendance -> AttendanceScreen()
            }
        }
    }
}