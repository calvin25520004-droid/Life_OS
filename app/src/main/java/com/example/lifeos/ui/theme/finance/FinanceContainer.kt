package com.example.lifeos.ui.theme.finance

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
fun FinanceScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp).verticalScroll(rememberScrollState())) {
        Text("Total Balance", color = Color.Gray)
        Text("$42,590.24", fontSize = 32.sp, fontWeight = FontWeight.Bold, color = Color(0xFF00ADEF))

        Spacer(modifier = Modifier.height(20.dp))

        // Card Income/Expense
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            FinanceCard("Income", "$8,200", Color(0xFFE1F5FE), Modifier.weight(1f))
            FinanceCard("Expenses", "$3,145", Color(0xFFFFF3E0), Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.height(24.dp))
        Text("Recent Transactions", fontWeight = FontWeight.Bold, fontSize = 18.sp)

        // Contoh List Transaksi
        TransactionItem("Apple Store", "-$1,299.00", "Technology")
        TransactionItem("Salary Credit", "+$4,500.00", "Income")
    }
}

@Composable
fun TransactionItem(x0: String, x1: String, x2: String) {

}

@Composable
fun FinanceCard(title: String, amount: String, color: Color, modifier: Modifier) {
    Card(modifier = modifier, colors = CardDefaults.cardColors(containerColor = color)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(title, fontSize = 12.sp)
            Text(amount, fontWeight = FontWeight.Bold, fontSize = 18.sp)
        }
    }
}