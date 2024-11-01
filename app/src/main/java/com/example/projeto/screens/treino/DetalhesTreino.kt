package com.example.projeto.screens.treino

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.projeto.reuse.BottomNavigationBar
import com.example.projeto.reuse.Header

@Composable
fun DetalhesTreinoScreen(nome:String,tipoExercicio: String, dia: Int, duracao: String, outdoor: Boolean, pontoInicial: String, pontoFinal: String, navController: NavHostController) {
    Scaffold(
        topBar = { Header(navController) },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Row (verticalAlignment = Alignment.CenterVertically){
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier.size(30.dp).clickable {
                            navController.popBackStack()
                        },
                        tint = Color.Black
                    )
                    Text(
                        text = "$nome",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }

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
                        text = "Tipo: ",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Text(
                        text = tipoExercicio,
                        fontSize = 16.sp,
                        color = Color(0xFFFF5722)
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Descricao: ",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .border(
                            width = 0.5.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(20.dp)
                ),
                    contentAlignment = Alignment.TopStart
                ) {
                    Text(text = "Descricao", color = Color.Black, modifier = Modifier.padding(horizontal = 20.dp))
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
        bottomBar = { BottomNavigationBar(navController) },
        containerColor = Color.White
    )
}

@Preview(showBackground = true)
@Composable
fun DetalhesTreinoScreenPreview() {
    val navController = rememberNavController()
    DetalhesTreinoScreen(
        nome = "Corrida 45 minutos",
        tipoExercicio = "Outdoor",
        dia = 10,
        duracao = "45 minutos",
        outdoor = true,
        pontoInicial = "Lustosa",
        pontoFinal = "Lustosa",
        navController = navController
    )
}