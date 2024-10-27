package com.example.projeto.screens

import com.example.projeto.reuse.Header
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projeto.R
import com.example.projeto.reuse.BottomNavigationBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Desafio(dia: Int, nomes: List<String>, dias: List<Int>, modifier: Modifier = Modifier) {
    val leaderboardData = nomes.zip(dias)
    val progress = dia / 75f

    Scaffold(
        topBar = {
            Header()
        },
        content = {
            Column(modifier = Modifier.padding(10.dp, 80.dp)) {
                Text(
                    text = "A sua streak está no dia $dia!",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(10.dp, 0.dp)
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                        .background(Color.LightGray, RoundedCornerShape(4.dp))
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(progress)
                            .height(20.dp)
                            .background(Color(0xFFFF5722), RoundedCornerShape(4.dp))
                            .padding(10.dp, 0.dp)
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Leaderboard Atual:",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(10.dp)
                )

                Column {
                    leaderboardData.forEach { (name, streakDays) ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp)
                                .background(Color(0xFFEEEEEE), RoundedCornerShape(8.dp))
                                .padding(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = name,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                modifier = Modifier.weight(1f)
                            )
                            Text(
                                text = "$streakDays dias",
                                fontWeight = FontWeight.Medium,
                                color = Color.DarkGray,
                                modifier = Modifier.padding(end = 8.dp)
                            )
                            Icon(
                                imageVector = Icons.Filled.Info,
                                contentDescription = "Ver detalhes",
                                tint = Color(0xFFFF5722),
                                modifier = Modifier
                                    .size(24.dp)
                                    .clickable {
                                    }
                            )
                        }
                    }
                }

                Image(
                    painter = painterResource(id = R.drawable.logo75),
                    contentDescription = "Cristiano Ronaldo",
                    modifier = Modifier.fillMaxWidth()
                        .height(400.dp),
                    contentScale = ContentScale.Crop
                )
            }
        },
        bottomBar = {
            BottomNavigationBar()
        }
    )
}
