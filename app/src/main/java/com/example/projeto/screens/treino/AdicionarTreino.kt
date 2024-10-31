package com.example.projeto.screens.treino

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.projeto.reuse.CaixaTexto
import com.example.projeto.reuse.Header

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AdiconarTreino(nomes: List<String>, paginas: List<Int>, modifier: Modifier = Modifier, navController: NavHostController) {
    val leaderboardData = nomes.zip(paginas)
    var treino by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            Header(navController)
        },
        content = {
            Column(modifier = Modifier.padding(10.dp, 80.dp)) {
                Text(
                    text = "Treinos",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                )

                Spacer(modifier = Modifier.height(10.dp))

                CaixaTexto(
                    label = "Pesquisar",
                    value = treino,
                    onValueChange = { treino = it },
                    isPassword = false
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Histórico",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.height(10.dp))

                Column {
                    leaderboardData.forEach { (name, pages) ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp)
                                .background(Color.LightGray, RoundedCornerShape(8.dp))
                                .padding(8.dp, 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(
                                modifier = Modifier.weight(1f)
                            ) {
                                Text(
                                    text = name,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )
                                Text(
                                    text = "$pages Páginas Lidas",
                                    color = Color.DarkGray,
                                    fontSize = 14.sp
                                )
                            }

                            Icon(
                                imageVector = Icons.Filled.AddCircle,
                                contentDescription = "Ver detalhes",
                                tint = Color(0xFFFF5722),
                                modifier = Modifier
                                    .size(24.dp)
                                    .clickable {
                                        navController.navigate("Treinos")
                                    }
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                }

            }
        },
        bottomBar = {
            BottomNavigationBar(navController)
        }
    )
}

@Preview(showBackground = true)
@Composable
fun AdiconarTreinoPreview() {
    val navController = rememberNavController()
    AdiconarTreino(listOf("A Arte de ter sempre razão","Efeito 1%"), listOf(16, 40), navController = navController)
}