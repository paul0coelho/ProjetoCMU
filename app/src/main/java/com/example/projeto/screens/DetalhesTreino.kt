package com.example.projeto.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projeto.reuse.BottomNavigationBar
import com.example.projeto.reuse.Header

@Composable
fun DetalhesTreinoScreen(tipoExercicio: String, dia: Int, duracao: String, outdoor: Boolean, pontoInicial: String, pontoFinal: String) {
    Scaffold(
        topBar = { Header() },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "$tipoExercicio",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Dia: ",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Text(
                        text = "$dia",
                        fontSize = 16.sp,
                        color = Color(0xFFFF5722)
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Duração: ",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Text(
                        text = duracao,
                        fontSize = 16.sp,
                        color = Color(0xFFFF5722)
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Outdoor: ",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Text(
                        text = if (outdoor) "Sim" else "Não",
                        fontSize = 16.sp,
                        color = Color(0xFFFF5722)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Ponto Inicial
                Text(
                    text = "Ponto inicial: $pontoInicial",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .background(Color(0xFF2C2C2C), shape = RoundedCornerShape(8.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Mapa - Ponto Inicial", color = Color.White)
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Ponto Final
                Text(
                    text = "Ponto final: $pontoFinal",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .background(Color(0xFF2C2C2C), shape = RoundedCornerShape(8.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Mapa - Ponto Final", color = Color.White)
                }
            }
        },
        bottomBar = { BottomNavigationBar() },
        containerColor = Color.White
    )
}

@Preview(showBackground = true)
@Composable
fun DetalhesTreinoScreenPreview() {
    DetalhesTreinoScreen(
        tipoExercicio = "Corrida 45 minutos",
        dia = 10,
        duracao = "45 minutos",
        outdoor = true,
        pontoInicial = "Lustosa",
        pontoFinal = "Lustosa"
    )
}