package com.example.projeto.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projeto.reuse.BottomNavigationBar
import com.example.projeto.reuse.Header



//É preciso rever todo





@Composable
fun CalorieScreen() {
    Scaffold(
        topBar = { Header() },
        content= { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                CalorieHeader()
                MealSection(
                    "Pequeno-Almoço",
                    50,
                    listOf("Bolacha Marinheira" to 25, "Bolacha Marinheira" to 25)
                )
                MealSection(
                    "Almoço",
                    500,
                    listOf("Picanha grelhada(100g)" to 250, "Picanha grelhada(100g)" to 250)
                )
                MealSection("Jantar", 750, listOf("Hamburguer fast food" to 750))
            }
        },
        bottomBar = { BottomNavigationBar() },
        containerColor = Color.White

    )
}

@Composable
fun CalorieHeader() {
    Text(text = "Calorias", fontSize = 26.sp, fontWeight = FontWeight.Bold)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFD5D4D4), shape = RoundedCornerShape(8.dp))
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "1750\nMeta", fontWeight = FontWeight.Bold, color = Color.Black, fontSize = 18.sp)
        Text(text = "-", fontWeight = FontWeight.Bold, color = Color.Black, fontSize = 18.sp)
        Text(text = "1250\nIngeridas", fontWeight = FontWeight.Bold, color = Color.Black, fontSize = 18.sp)
        Text(text = "=", fontWeight = FontWeight.Bold, color = Color.Black, fontSize = 18.sp)
        Text(text = "500\nRestantes", fontWeight = FontWeight.Bold, color = Color.Black, fontSize = 18.sp)
    }
}

@Composable
fun MealSection(mealName: String, totalCalories: Int, items: List<Pair<String, Int>>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF5F5F5), shape = RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        Text(text = "$mealName - $totalCalories", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(8.dp))

        items.forEach { (food, calories) ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = food, fontSize = 16.sp, color = Color.Black)
                Text(text = calories.toString(), fontSize = 16.sp, color = Color.Black)
            }
        }
        Text(
            text = "ADICIONAR ALIMENTO",
            fontSize = 14.sp,
            color = Color(0xFFFF5722),
            fontWeight = FontWeight.Bold,
        )
    }
}


@Preview(showBackground = true)
@Composable
fun CalorieScreenPreview() {
    CalorieScreen()
}
