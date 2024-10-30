package com.example.projeto.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Search
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
import com.example.projeto.reuse.BottomNavigationBar
import com.example.projeto.reuse.Header

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LeaderBoardDetalhes(position: Int, userName: String, currentStreak: Int, maxStreak: Int, bookTitles: List<String>, pagesRead: List<Int>, modifier: Modifier = Modifier) {
    val leaderboardData = bookTitles.zip(pagesRead)

    Scaffold(
        topBar = {
            Header()
        },
        content = {
            Column(modifier = Modifier.padding(10.dp, 80.dp)) {
                // Leaderboard Header
                Text(
                    text = "LeaderBoard Atual",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "$position# $userName",
                    color = Color(0xFFFF5722),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Streak Atual: $currentStreak dias",
                    fontSize = 16.sp
                )

                Text(
                    text = "Maior Streak Registada: $maxStreak dias",
                    fontSize = 16.sp
                )

                Spacer(modifier = Modifier.height(30.dp))

                // Top 3 Livros Lidos
                Text(
                    text = "Top 3 Livros lidos:",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(10.dp))

                Column {
                    leaderboardData.forEach { (title, pages) ->
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
                                    text = title,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )
                                Text(
                                    text = "$pages páginas lidas",
                                    color = Color(0xFFFF5722),
                                    fontSize = 14.sp
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                }

                Spacer(modifier = Modifier.height(30.dp))

                // Última foto da evolução
                Text(
                    text = "Última foto da evolução:",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .background(Color.Gray, RoundedCornerShape(8.dp))
                )
            }
        },
        bottomBar = {
            BottomNavigationBar()
        }
    )
}

@Preview(showBackground = true)
@Composable
fun LeaderBoardDetalhesPreview() {
    LeaderBoardDetalhes(
        position = 1,
        userName = "Andy Frisella",
        currentStreak = 1000,
        maxStreak = 1000,
        bookTitles = listOf("A Arte de ter sempre razão", "Efeito 1%", "Não me podem magoar"),
        pagesRead = listOf(86, 76, 40)
    )
}