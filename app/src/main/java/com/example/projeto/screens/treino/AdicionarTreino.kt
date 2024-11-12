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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
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
import com.example.projeto.reuse.CaixaTexto
import com.example.projeto.reuse.Header

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AdiconarTreino(nomes: List<String>, paginas: List<Int>, modifier: Modifier = Modifier, navController: NavHostController) {
    val leaderboardData = nomes.zip(paginas)
    var treino by remember { mutableStateOf("") }

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    val titleFontSize = (screenWidth.value * 0.05).sp
    val subtitleFontSize = (screenWidth.value * 0.04).sp
    val contentFontSize = (screenWidth.value * 0.03).sp
    val bigIconSize = (screenWidth.value * 0.06).dp
    val smallIconSize = (screenWidth.value * 0.05).dp
    Scaffold(
        topBar = {
            Header(navController)
        },
        content = {
            Column(modifier = Modifier.padding(10.dp, 80.dp)) {
                Row(modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically){

                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            modifier = Modifier.size(bigIconSize).clickable {
                                navController.popBackStack()
                            },
                            tint = colorResource(id = R.color.black)
                        )
                    Text(
                        text = stringResource(id = R.string.Treino),
                        fontSize = titleFontSize,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.black),
                        modifier = Modifier.weight(1f)
                    )
                    Icon(
                        Icons.Filled.AddCircle,
                        contentDescription = "Profile",
                        modifier = Modifier.size(bigIconSize).clickable {
                            navController.navigate("AdicionarLivro")
                        },
                        tint = colorResource(id = R.color.LaranjaGeral),
                    )
                }


                Row(Modifier.padding(horizontal = 10.dp)) {
                    CaixaTexto(
                    label = stringResource(id = R.string.Pesquisar),
                    value = treino,
                    onValueChange = { treino = it },
                    isPassword = false, fontSize = titleFontSize, iconSize = smallIconSize
                )}

                Spacer(modifier = Modifier.height(20.dp))

                Column {
                    Text(
                    text = stringResource(id = R.string.Historico),
                    fontSize = titleFontSize,
                    fontWeight = FontWeight.Bold,
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    LazyColumn( ) {
                        items(leaderboardData) { (name) ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(colorResource(id = R.color.CinzaClaro), RoundedCornerShape(8.dp))
                                    .padding(8.dp, 4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Text(
                                        text = name,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = subtitleFontSize,
                                        color = colorResource(id = R.color.black),
                                        modifier=Modifier.padding(bottom = 10.dp)
                                    )
                                    Text(
                                        text = "4 Séries de 10 repetições",
                                        color = colorResource(id = R.color.Gray),
                                        fontSize = contentFontSize
                                    )
                                }

                                Icon(
                                    imageVector = Icons.Filled.AddCircle,
                                    contentDescription = "Ver detalhes",
                                    tint = colorResource(id = R.color.LaranjaGeral),
                                    modifier = Modifier
                                        .size(smallIconSize)
                                        .clickable {
                                            navController.navigate("Treinos")
                                        }
                                )
                            }
                            Spacer(modifier = Modifier.height(10.dp))
                        }
                    }
                }
            }
        },
        bottomBar = {
            BottomNavigationBar(navController, "Diario")
        },
        containerColor = colorResource(id = R.color.white)
    )
}

@Preview(showBackground = true)
@Composable
fun AdiconarTreinoPreview() {
    val navController = rememberNavController()
    AdiconarTreino(listOf("Supino com barra","Agachamento barra livre"), listOf(16, 40), navController = navController)
}
