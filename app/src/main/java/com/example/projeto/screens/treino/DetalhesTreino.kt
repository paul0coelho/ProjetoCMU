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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.projeto.R
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
                        tint = colorResource(id = R.color.black)
                    )
                    Text(
                        text = "$nome",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = stringResource(id = R.string.Dia),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.black)
                    )
                    Text(
                        text = "$dia",
                        fontSize = 16.sp,
                        color = colorResource(id = R.color.LaranjaGeral)
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = stringResource(id = R.string.Duracao2),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.black)
                    )
                    Text(
                        text = duracao,
                        fontSize = 16.sp,
                        color = colorResource(id = R.color.LaranjaGeral)
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = stringResource(id = R.string.Tipo2),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.black)
                    )
                    Text(
                        text = tipoExercicio,
                        fontSize = 16.sp,
                        color = colorResource(id = R.color.LaranjaGeral)
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = stringResource(id = R.string.Descricao2),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.black)
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .border(
                            width = 0.5.dp,
                            color = colorResource(id = R.color.black),
                            shape = RoundedCornerShape(20.dp)
                ),
                    contentAlignment = Alignment.TopStart
                ) {
                    Text(text = stringResource(id = R.string.Descricao), color = colorResource(id = R.color.black), modifier = Modifier.padding(horizontal = 20.dp))
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Ponto Inicial
                Text(
                    text = stringResource(id = R.string.PontoInicial, pontoInicial),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.black)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .background(colorResource(id = R.color.DarkGray), shape = RoundedCornerShape(8.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Mapa - Ponto Inicial", color = colorResource(id = R.color.white))
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Ponto Final
                Text(
                    text = stringResource(id = R.string.PontoFinal, pontoFinal),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.black)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .background(colorResource(id = R.color.DarkGray), shape = RoundedCornerShape(8.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Mapa - Ponto Final", color = colorResource(id = R.color.white))
                }
            }
        },
        bottomBar = { BottomNavigationBar(navController) },
        containerColor = colorResource(id = R.color.white)
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