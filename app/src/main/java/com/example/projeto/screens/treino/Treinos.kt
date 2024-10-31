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
import androidx.compose.material.icons.filled.MoreVert
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

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Treinos(navController: NavHostController) {
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
                Text(
                    text = "Hoje ja treinou 1 vez! Falta 1",
                    Modifier.padding(top = 20.dp),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Os seus treinos de hoje:",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.height(25.dp))

                Column {
                    Row(modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically){
                        Text(
                            text = "Indoor:",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFFF5722),
                            modifier = Modifier.weight(1f)
                        )
                        Icon(
                            Icons.Filled.AddCircle,
                            contentDescription = "Profile",
                            modifier = Modifier.size(24.dp).clickable {
                                navController.navigate("AdicionarTreino")
                            },
                            tint = Color(0xFFFF5722),
                        )
                    }

                    Spacer(modifier = Modifier.height(15.dp))
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
                                    text = "Corrida 45 minutos",
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )
                            }

                            Icon(
                                imageVector = Icons.Filled.MoreVert,
                                contentDescription = "Ver detalhes",
                                tint = Color(0xFFFF5722),
                                modifier = Modifier
                                    .size(24.dp)
                                    .clickable {
                                        navController.navigate("DetalhesTreinos")
                                    }
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))

                }
                Spacer(modifier = Modifier.height(25.dp))

                Column {
                    Row(modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically){
                        Text(
                            text = "Outdoor:",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFFF5722),
                            modifier = Modifier.weight(1f)
                        )
                        Icon(
                            Icons.Filled.AddCircle,
                            contentDescription = "Profile",
                            modifier = Modifier.size(24.dp).clickable {
                                navController.navigate("AdicionarLivro")
                            },
                            tint = Color(0xFFFF5722),
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))
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
                        }
                    }

                }
            }
            },
        bottomBar = {
            BottomNavigationBar(navController)
        },
        containerColor = Color.White
    )
}

@Preview(showBackground = true)
@Composable
fun TreinosPreview() {
    val navController = rememberNavController()
    Treinos(navController = navController)
}
