package com.example.projeto.screens.principais

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.platform.LocalConfiguration
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
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    val titleFontSize = (screenWidth.value * 0.04).sp
    val contentFontSize = (screenWidth.value * 0.03).sp
    val bigIconSize = (screenWidth.value * 0.07).dp
    val smallIconSize = (screenWidth.value * 0.05).dp
    Scaffold(
        topBar = {
            Header(navController)
        },
        content = {
            Column(modifier = Modifier.padding(10.dp, 80.dp)) {
                Column(modifier.weight(.2f)) {
                    Text(
                        text =  stringResource(id = R.string.Pontuacao, dia),
                        fontSize = titleFontSize,
                        fontWeight = FontWeight.Bold,
                        modifier=Modifier.weight(0.3f)
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxWidth().weight(.3f)
                            .background(colorResource(id = R.color.Cinza), RoundedCornerShape(4.dp))
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(progress)
                                .fillMaxHeight()
                                .background(colorResource(id = R.color.LaranjaGeral), RoundedCornerShape(4.dp))
                                .padding(10.dp, 0.dp)
                        )
                    }
                }
                Column(modifier.weight(1f).padding(top = 20.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = stringResource(id = R.string.LeaderBoard),
                            fontSize = titleFontSize,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(10.dp).weight(4f)
                        )

                        Icon(
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = "Ver página leaderboard",
                            tint = colorResource(id = R.color.black),
                            modifier = Modifier
                                .size(bigIconSize)
                                .clickable { navController.navigate("LeaderBoard") }
                        )
                    }

                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        items(leaderboardData.size) { index ->
                            val (name, streakDays) = leaderboardData[index]
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(4.dp)
                                    .background(
                                        colorResource(id = R.color.CinzaClaro),
                                        shape = RoundedCornerShape(8.dp)
                                    )
                                    .padding(8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = name,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = contentFontSize,
                                    color = colorResource(id = R.color.black),
                                    modifier = Modifier.weight(1f)
                                )
                                Text(
                                    text = stringResource(id = R.string.LeaderBoard, streakDays),
                                    fontWeight = FontWeight.Medium,
                                    fontSize = contentFontSize,
                                    color = colorResource(id = R.color.DarkGray),
                                    modifier = Modifier.padding(end = 8.dp)
                                )
                                Icon(
                                    imageVector = Icons.Filled.Info,
                                    contentDescription = "Ver detalhes",
                                    tint = colorResource(id = R.color.LaranjaGeral),
                                    modifier = Modifier
                                        .size(smallIconSize)
                                        .clickable {
                                            navController.navigate("LeaderBoardDetalhes")
                                        }
                                )
                            }
                        }
                    }
                }

                Image(
                    painter = painterResource(id = R.drawable.logo75),
                    contentDescription = "Logo",
                    modifier = Modifier.fillMaxSize().weight(1f),
                    contentScale = ContentScale.Fit
                )
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
fun DesafioPreview() {
    val navController = rememberNavController()
    Desafio(10, listOf("Andry Frisella","John Due", "Paulo Coelho", "Eu","a","b","a","b","a","b","a","b"), listOf(1000, 900, 852, 10,2,3,4,5,6,7,8,9), navController = navController)
}
