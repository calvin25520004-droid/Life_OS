package com.example.lifeos.ui.theme.schedule

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ScheduleScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("October 24, 2023", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))

        // Timeline Item
        ScheduleItem("08:00 AM", "Daily Standup Meeting", "Completed", true)
        ScheduleItem("10:00 AM", "Project Review", "In Progress", false)
    }
}

@Composable
fun ScheduleItem(time: String, title: String, status: String, isDone: Boolean) {
    Row(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
        Text(time, modifier = Modifier.width(80.dp), fontSize = 12.sp)
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = if(isDone) Color(0xFFF5F5F5) else Color.White),
            border = BorderStroke(1.dp, Color(0xFFEEEEEE))
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(title, fontWeight = FontWeight.Bold)
                Text(status, color = if(isDone) Color.Gray else Color(0xFF00ADEF), fontSize = 10.sp)
            }
        }
    }
}