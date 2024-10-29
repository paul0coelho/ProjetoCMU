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


@Composable
fun CalorieScreen( metaCalorias: Int, caloriasIngeridas: Int, refeicoes: List<Pair<String, Pair<Int, List<Pair<String, Int>>>>>) {

    val caloriasRestantes = metaCalorias - caloriasIngeridas

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
                CalorieHeader(metaCalorias, caloriasIngeridas, caloriasRestantes)

                refeicoes.forEach { (nomeRefeicao, infoRefeicao) ->
                    val (totalCalorias, itens) = infoRefeicao
                    MealSection(mealName = nomeRefeicao, totalCalories = totalCalorias, items = itens)
                }
            }
        },
        bottomBar = { BottomNavigationBar() },
        containerColor = Color.White

    )
}

@Composable
fun CalorieHeader(metaCalorias: Int, caloriasIngeridas: Int, caloriasRestantes: Int) {
    Text(text = "Calorias", fontSize = 26.sp, fontWeight = FontWeight.Bold)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFD5D4D4), shape = RoundedCornerShape(8.dp))
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "$metaCalorias\nMeta", fontWeight = FontWeight.Bold, color = Color.Black, fontSize = 18.sp)
        Text(text = "-", fontWeight = FontWeight.Bold, color = Color.Black, fontSize = 18.sp)
        Text(text = "$caloriasIngeridas\nIngeridas", fontWeight = FontWeight.Bold, color = Color.Black, fontSize = 18.sp)
        Text(text = "=", fontWeight = FontWeight.Bold, color = Color.Black, fontSize = 18.sp)
        Text(text = "$caloriasRestantes\nRestantes", fontWeight = FontWeight.Bold, color = Color.Black, fontSize = 18.sp)
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
    CalorieScreen(
        metaCalorias = 1750,
        caloriasIngeridas = 1250,
        refeicoes = listOf(
            "Pequeno-Almoço" to (50 to listOf("Bolacha Marinheira" to 25, "Bolacha Marinheira" to 25)),
            "Almoço" to (500 to listOf("Picanha grelhada (100g)" to 250, "Arroz branco" to 250)),
            "Jantar" to (750 to listOf("Hambúrguer fast food" to 750))
        )
    )
}