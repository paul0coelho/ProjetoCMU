package com.example.projeto.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.projeto.reuse.BottomNavigationBar
import com.example.projeto.reuse.Header

@Composable
fun CalorieScreen(metaCalorias: Int, caloriasIngeridas: Int, alimentos: List<Triple<String, Int, String>>) {
    val caloriasRestantes = metaCalorias - caloriasIngeridas

    Scaffold(
        topBar = { Header() },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CalorieHeader(metaCalorias, caloriasIngeridas, caloriasRestantes)

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFF5F5F5), RoundedCornerShape(8.dp))
                        .padding(8.dp)
                ) {
                    alimentos.forEach { (food, calories, time) ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 10.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = time, fontSize = 16.sp, color = Color.Gray)
                            Text(text = food, fontSize = 16.sp, color = Color.Black)
                            Text(text = "$calories kcal", fontSize = 16.sp, color = Color.Black)
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "ADICIONAR ALIMENTO",
                        fontSize = 14.sp,
                        color = Color(0xFFFF5722),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.align(Alignment.Start).clickable {  }
                    )
                }
            }
        },
        bottomBar = { BottomNavigationBar() },
        containerColor = Color.White
    )
}

@Composable
fun CalorieHeader(metaCalorias: Int, caloriasIngeridas: Int, caloriasRestantes: Int) {
    Text(text = "Calorias", fontSize = 22.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 8.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFD5D4D4), shape = RoundedCornerShape(8.dp))
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "$metaCalorias\nMeta", fontWeight = FontWeight.Bold, color = Color.Black, fontSize = 16.sp)
        Text(text = "-", fontWeight = FontWeight.Bold, color = Color.Black, fontSize = 16.sp)
        Text(text = "$caloriasIngeridas\nIngeridas", fontWeight = FontWeight.Bold, color = Color.Black, fontSize = 16.sp)
        Text(text = "=", fontWeight = FontWeight.Bold, color = Color.Black, fontSize = 16.sp)
        Text(text = "$caloriasRestantes\nRestantes", fontWeight = FontWeight.Bold, color = Color.Black, fontSize = 16.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun CalorieScreenPreview() {
    CalorieScreen(
        metaCalorias = 1750,
        caloriasIngeridas = 1250,
        alimentos = listOf(
            Triple("Bolacha Marinheira", 25, "8:00"),
            Triple("Bolacha Marinheira", 25, "8:30"),
            Triple("Picanha grelhada (100g)", 250, "12:00"),
            Triple("Arroz branco", 250, "12:30"),
            Triple("Hambúrguer fast food", 750, "20:30")
        )
    )
}
