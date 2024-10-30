package com.example.projeto.screens.principais

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.projeto.reuse.BottomNavigationBar
import com.example.projeto.reuse.Header

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiaryScreen(navController: NavHostController) {
    Scaffold(
        topBar = { Header(navController) },
        content= { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(color = Color.White),
                verticalArrangement = Arrangement.spacedBy(20.dp),
            ) {

                Column(Modifier.weight(1f).align(Alignment.CenterHorizontally)) {
                    Text(
                    "Foto do dia",
                        Modifier.fillMaxWidth(),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    fontSize = 25.sp
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth().height(height = 250.dp).padding(horizontal = 35.dp).padding(vertical = 10.dp)
                            .clip(RoundedCornerShape(30.dp))
                            .background(color = Color(0xFFFF5722))
                            .clickable {
                                // Ação ao clicar
                            },
                        contentAlignment = Alignment.Center
                    ) {}
                }

                Spacer(modifier = Modifier.height(5.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth().fillMaxHeight().weight(1f),
                    contentAlignment = Alignment.Center // Alinha tudo no centro
                ) {
                    Column(Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(16.dp) // Espaço entre as linhas
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(16.dp),
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                Modifier
                                    .background(color = Color(0xFFEEEEF0)).weight(1f)
                                    .clip(RoundedCornerShape(30.dp))
                                    .clickable {
                                        navController.navigate("Calorias")
                                    },
                                contentAlignment = Alignment.Center
                            ) {
                                Column {
                                    Text(text = "Calorias", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                                    Text(text = "500 restantes", fontWeight = FontWeight.Bold, fontSize = 40.sp, color = Color(0xFFFF5722))
                                }
                            }
                            Box(
                                Modifier
                                    .background(color = Color(0xFFEEEEF0))
                                    .weight(1f)
                                    .clip(RoundedCornerShape(30.dp))
                                    .clickable {
                                        navController.navigate("IngestaoAgua")
                                    },
                                contentAlignment = Alignment.Center
                            ) {
                                Column {
                                    Text(text = "Água", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                                    Text(text = "1,5/3 L", fontWeight = FontWeight.Bold, fontSize = 40.sp, color = Color(0xFFFF5722))
                                }
                            }
                        }
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(16.dp),
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                Modifier
                                    .background(color = Color(0xFFEEEEF0))
                                    .weight(1f)
                                    .clip(RoundedCornerShape(30.dp))
                                    .clickable {
                                        navController.navigate("Livros")
                                    },
                                contentAlignment = Alignment.Center
                            ) {
                                Column {
                                    Text(text = "Páginas Lidas", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                                    Text(text = "3/10", fontWeight = FontWeight.Bold, fontSize = 40.sp, color = Color(0xFFFF5722))
                                }
                            }
                            Box(
                                Modifier
                                    .background(color = Color(0xFFEEEEF0))
                                    .weight(1f)
                                    .clip(RoundedCornerShape(30.dp))
                                    .clickable {
                                        navController.navigate("Treinos")
                                    },
                                contentAlignment = Alignment.Center
                            ) {
                                Column {
                                    Text(text = "Treinos", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                                    Text(text = "0/2", fontWeight = FontWeight.Bold, fontSize = 30.sp, color = Color(0xFFFF5722))
                                }
                            }
                        }
                    }
                }
            }
        } ,
        bottomBar = { BottomNavigationBar(navController) },
        containerColor = Color.White
    )
}


@Preview(showBackground = true)
@Composable
fun DiaryScreenPreview() {
    val navController = rememberNavController()
    DiaryScreen(navController = navController)
}