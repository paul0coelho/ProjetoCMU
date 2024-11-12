package com.example.projeto.screens.principais

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.platform.LocalConfiguration
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

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LeaderBoardDetalhes(position: Int, userName: String, currentStreak: Int, maxStreak: Int, bookTitles: List<String>, pagesRead: List<Int>, modifier: Modifier = Modifier, navController: NavHostController) {
    val leaderboardData = bookTitles.zip(pagesRead)

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    val titleFontSize = (screenWidth.value * 0.05).sp
    val contentFontSize = (screenWidth.value * 0.03).sp
    val bigIconSize = (screenWidth.value * 0.06).dp
    val smallIconSize = (screenWidth.value * 0.05).dp

    Scaffold(
        topBar = {
            Header(navController)
        },
        content = {
            Column(modifier = Modifier.padding(10.dp, 80.dp).padding(bottom = 20.dp)) {
                Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(.05f)){
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier.size(bigIconSize).clickable {
                            navController.popBackStack()
                        },
                        tint = colorResource(id = R.color.black)
                    )
                    Text(
                        text = stringResource(id = R.string.LeaderBoard),
                        fontSize = titleFontSize,
                        fontWeight = FontWeight.Bold,
                    )
                }

                Column(Modifier.weight(.15f).padding(top = 10.dp), verticalArrangement = Arrangement.SpaceBetween) {
                    Text(
                        text = "$position# $userName",
                        color = colorResource(id = R.color.LaranjaGeral),
                        fontSize = titleFontSize,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = stringResource(id = R.string.PontuacaoDetalhada, currentStreak) ,
                        fontSize = contentFontSize
                    )

                    Text(
                        text = stringResource(id = R.string.PontuacaoMaior, maxStreak),
                        fontSize = contentFontSize
                    )
                }


                Column(modifier=Modifier.weight(.35f).padding(top = 15.dp), verticalArrangement =Arrangement.SpaceBetween) {
                    Text(
                        text = stringResource(id = R.string.Top3Livros),
                        fontSize = titleFontSize,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(.15f)
                    )

                    Column(modifier.weight(.85f).fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
                        leaderboardData.forEach { (title, pages) ->
                            Row(
                                modifier = Modifier
                                    .fillMaxSize().weight(1f).padding(vertical = 2.dp)
                                    .background(colorResource(id = R.color.CinzaClaro), RoundedCornerShape(8.dp)).padding(10.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(verticalArrangement = Arrangement.SpaceBetween, modifier =Modifier.fillMaxSize()){
                                    Text(
                                        text = title,
                                        fontWeight = FontWeight.Bold,
                                        color = colorResource(id = R.color.black),
                                        fontSize = contentFontSize
                                    )
                                    Text(
                                        text = stringResource(id = R.string.NumeroPaginasLidas, pages),
                                        color = colorResource(id = R.color.LaranjaGeral),
                                        fontSize = contentFontSize
                                    )
                                }
                            }
                        }
                    }

                }

                Column(Modifier.weight(.45f).padding(top = 10.dp)) {
                        Text(
                        text = stringResource(id = R.string.UltimaFoto),
                        fontSize = titleFontSize,
                        fontWeight = FontWeight.Bold,
                            modifier = Modifier.weight(.1f)
                        )

                        Box(
                            modifier = Modifier
                                .fillMaxSize().weight(.9f).padding(top = 10.dp)
                                .background(colorResource(id = R.color.Cinza), RoundedCornerShape(8.dp))
                        )
                }

            }
        },
        bottomBar = {
            BottomNavigationBar(navController, "Desafio")
        },
        containerColor = Color.White
    )
}

@Preview(showBackground = true)
@Composable
fun LeaderBoardDetalhesPreview() {
    val navController = rememberNavController()
    LeaderBoardDetalhes(
        position = 1,
        userName = "Andy Frisella",
        currentStreak = 1000,
        maxStreak = 1000,
        bookTitles = listOf("A Arte de ter sempre razão", "Efeito 1%", "Não me podem magoar"),
        pagesRead = listOf(86, 76, 40),
        navController = navController
    )
}
