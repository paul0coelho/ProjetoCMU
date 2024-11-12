package com.example.projeto.screens.treino

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
fun DetalhesTreinoScreen(nome:String,tipoExercicio: String, dia: Int, duracao: String, outdoor: Boolean, pontoInicial: String, pontoFinal: String, navController: NavHostController) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    val titleFontSize = (screenWidth.value * 0.06).sp
    val subtitleFontSize = (screenWidth.value * 0.05).sp
    val contentFontSize = (screenWidth.value * 0.03).sp
    val bigIconSize = (screenWidth.value * 0.06).dp
    val smallIconSize = (screenWidth.value * 0.05).dp
    Scaffold(
        topBar = { Header(navController) },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp,80.dp).verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Row (verticalAlignment = Alignment.CenterVertically){
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier.size(bigIconSize).clickable {
                            navController.popBackStack()
                        },
                        tint = colorResource(id = R.color.black)
                    )
                    Text(
                        text = "$nome",
                        fontSize = titleFontSize,
                        fontWeight = FontWeight.Bold,
                    )
                }

                Column(modifier = Modifier.padding(horizontal = 10.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = stringResource(id = R.string.Dia),
                            fontSize = subtitleFontSize,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.black)
                        )
                        Text(
                            text = "$dia",
                            fontSize = subtitleFontSize,
                            color = colorResource(id = R.color.LaranjaGeral)
                        )
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = stringResource(id = R.string.Duracao2),
                            fontSize = subtitleFontSize,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.black)
                        )
                        Text(
                            text = duracao,
                            fontSize = subtitleFontSize,
                            color = colorResource(id = R.color.LaranjaGeral)
                        )
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = stringResource(id = R.string.Tipo2),
                            fontSize = subtitleFontSize,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.black)
                        )
                        Text(
                            text = tipoExercicio,
                            fontSize = subtitleFontSize,
                            color = colorResource(id = R.color.LaranjaGeral)
                        )
                    }


                }
                Column(Modifier.padding(horizontal = 10.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(bottom = 10.dp)) {
                        Text(
                            text = stringResource(id = R.string.Descricao2),
                            fontSize = subtitleFontSize,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.black)
                        )
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxSize().height((screenHeight.value * 0.10).dp)
                            .border(
                                width = 0.5.dp,
                                color = colorResource(id = R.color.black),
                                shape = RoundedCornerShape(20.dp)
                            ),
                        contentAlignment = Alignment.TopStart
                    ) {
                        Text(text = stringResource(id = R.string.Descricao), color = colorResource(id = R.color.black), modifier = Modifier.padding(horizontal = 20.dp), fontSize = contentFontSize)
                    }
                }


                Spacer(modifier = Modifier.height(10.dp))
                Column(Modifier.padding(horizontal = 10.dp)) {
                    Text(
                    text = stringResource(id = R.string.PontoInicial, pontoInicial),
                    fontSize = subtitleFontSize,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.black), modifier = Modifier.padding(bottom = 10.dp)
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height((screenHeight.value * 0.20).dp)
                            .background(colorResource(id = R.color.DarkGray), shape = RoundedCornerShape(8.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "Mapa - Ponto Inicial", color = colorResource(id = R.color.white))
                    }
                }


                Spacer(modifier = Modifier.height(10.dp))
                Column(Modifier.padding(horizontal = 10.dp)) {
                    Text(
                    text = stringResource(id = R.string.PontoFinal, pontoFinal),
                    fontSize = subtitleFontSize,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.black),modifier = Modifier.padding(bottom = 10.dp)
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height((screenHeight.value * 0.20).dp)
                            .background(colorResource(id = R.color.DarkGray), shape = RoundedCornerShape(8.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "Mapa - Ponto Final", color = colorResource(id = R.color.white))
                    }
                }

            }
        },
        bottomBar = { BottomNavigationBar(navController, "Diario") },
        containerColor = colorResource(id = R.color.white)
    )
}

@Preview(showBackground = true)
@Composable
fun DetalhesTreinoScreenPreview() {
    val navController = rememberNavController()
    DetalhesTreinoScreen(
        nome = "Corrida 45 minutos",
        tipoExercicio = "Outdoor",
        dia = 10,
        duracao = "45 minutos",
        outdoor = true,
        pontoInicial = "Lustosa",
        pontoFinal = "Lustosa",
        navController = navController
    )
}