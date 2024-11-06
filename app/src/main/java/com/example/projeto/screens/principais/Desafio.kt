package com.example.projeto.screens.principais

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
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

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Desafio(dia: Int, nomes: List<String>, dias: List<Int>, modifier: Modifier = Modifier, navController: NavHostController) {
    val leaderboardData = nomes.zip(dias)
    val progress = dia / 75f

    Scaffold(
        topBar = {
            Header(navController)
        },
        content = {
            Column(modifier = Modifier.padding(10.dp, 80.dp)) {
                Text(
                    text =  stringResource(id = R.string.Pontuacao, dia),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                        .background(colorResource(id = R.color.Cinza), RoundedCornerShape(4.dp))
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(progress)
                            .height(20.dp)
                            .background(colorResource(id = R.color.LaranjaGeral), RoundedCornerShape(4.dp))
                            .padding(10.dp, 0.dp)
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically){
                    Text(
                        text =  stringResource(id = R.string.LeaderBoard),
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(10.dp).weight(4f)
                    )

                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "Ver página leaderboard",
                        tint = colorResource(id = R.color.black),
                        modifier = Modifier
                            .size(36.dp)
                            .clickable {navController.navigate("LeaderBoard")}
                    )
                }

                Column {
                    leaderboardData.forEach { (name, streakDays) ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp)
                                .background(colorResource(id = R.color.CinzaClaro), RoundedCornerShape(8.dp))
                                .padding(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = name,
                                fontWeight = FontWeight.Bold,
                                color = colorResource(id = R.color.black),
                                modifier = Modifier.weight(1f)
                            )
                            Text(
                                text = stringResource(id = R.string.LeaderBoard, streakDays),
                                fontWeight = FontWeight.Medium,
                                color = colorResource(id = R.color.DarkGray),
                                modifier = Modifier.padding(end = 8.dp)
                            )
                            Icon(
                                imageVector = Icons.Filled.Info,
                                contentDescription = "Ver detalhes",
                                tint = colorResource(id = R.color.LaranjaGeral),
                                modifier = Modifier
                                    .size(24.dp)
                                    .clickable {
                                        navController.navigate("LeaderBoardDetalhes")
                                    }
                            )
                        }
                    }
                }

                Image(
                    painter = painterResource(id = R.drawable.logo75),
                    contentDescription = "Logo",
                    modifier = Modifier.fillMaxWidth()
                        .height(400.dp),
                    contentScale = ContentScale.Crop
                )
            }
        },
        bottomBar = {
            BottomNavigationBar(navController)
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DesafioPreview() {
    val navController = rememberNavController()
    Desafio(10, listOf("Andry Frisella","John Due", "Paulo Coelho", "Eu"), listOf(1000, 900, 852, 10), navController = navController)
}
