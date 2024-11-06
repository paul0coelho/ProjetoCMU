package com.example.projeto.screens.alimento

import androidx.compose.foundation.background
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.projeto.reuse.BottomNavigationBar
import com.example.projeto.reuse.Header
import androidx.compose.ui.res.stringResource
import com.example.projeto.R
import com.example.projeto.reuse.CaixaTexto

@Composable
fun CalorieScreen(metaCalorias: Int, caloriasIngeridas: Int, alimentos: List<Triple<String, Int, String>>, navController: NavHostController) {
    val caloriasRestantes = metaCalorias - caloriasIngeridas

    Scaffold(
        topBar = { Header(navController) },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CalorieHeader(metaCalorias, caloriasIngeridas, caloriasRestantes, navController)

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(colorResource(id = R.color.CinzaClaro), RoundedCornerShape(8.dp))
                        .padding(8.dp)
                ) {
                    alimentos.forEach { (food, calories, time) ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 10.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = time, fontSize = 16.sp, color = colorResource(id = R.color.Gray))
                            Text(text = food, fontSize = 16.sp, color = colorResource(id = R.color.black))
                            Text(text = "$calories kcal", fontSize = 16.sp, color = colorResource(id = R.color.black))
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = stringResource(id = R.string.AdicionarAlimento),
                        fontSize = 14.sp,
                        color = colorResource(id = R.color.LaranjaGeral),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.align(Alignment.Start).clickable {
                            navController.navigate("AdicionarAlimento")
                        }
                    )
                }
            }
        },
        bottomBar = { BottomNavigationBar(navController) },
        containerColor = colorResource(id = R.color.white)
    )
}

@Composable
fun CalorieHeader(metaCalorias: Int, caloriasIngeridas: Int, caloriasRestantes: Int, navController: NavHostController) {
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
            text = stringResource(id = R.string.Calorias),
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
        )
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(id = R.color.Cinza), shape = RoundedCornerShape(8.dp))
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "$metaCalorias\n${stringResource(id = R.string.Meta)}", fontWeight = FontWeight.Bold, color = colorResource(id = R.color.black), fontSize = 16.sp)
        Text(text = "-", fontWeight = FontWeight.Bold, color = Color.Black, fontSize = 16.sp)
        Text(text = "$caloriasIngeridas\n${stringResource(id = R.string.Ingeridas)}", fontWeight = FontWeight.Bold, color = colorResource(id = R.color.black), fontSize = 16.sp)
        Text(text = "=", fontWeight = FontWeight.Bold, color = Color.Black, fontSize = 16.sp)
        Text(text = "$caloriasRestantes\n${stringResource(id = R.string.Restantes)}", fontWeight = FontWeight.Bold, color = colorResource(id = R.color.black), fontSize = 16.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun CalorieScreenPreview() {
    val navController = rememberNavController()
    CalorieScreen(
        metaCalorias = 1750,
        caloriasIngeridas = 1250,
        navController = navController,
        alimentos = listOf(
            Triple("Bolacha Marinheira", 25, "8:00"),
            Triple("Bolacha Marinheira", 25, "8:30"),
            Triple("Picanha grelhada (100g)", 250, "12:00"),
            Triple("Arroz branco", 250, "12:30"),
            Triple("Hambúrguer fast food", 750, "20:30")
        )
    )
}
