package com.example.projeto.screens.alimento

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.projeto.R
import androidx.compose.ui.res.stringResource
import com.example.projeto.reuse.BottomNavigationBar
import com.example.projeto.reuse.CaixaTexto
import com.example.projeto.reuse.Header

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AdiconarAlimento(navController: NavHostController) {
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
        content = {paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)
                .padding(horizontal = 16.dp, vertical = 8.dp)) {
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
                        text = stringResource(id = R.string.Alimentos),
                        fontSize = titleFontSize,
                        fontWeight = FontWeight.Bold,
                    )
                }


                Spacer(modifier = Modifier.height(10.dp))
                
                var pesquisa by remember { mutableStateOf("") }
                CaixaTexto(
                    label = stringResource(id = R.string.Pesquisar),
                    value = pesquisa,
                    onValueChange = { pesquisa = it }, fontSize =subtitleFontSize , iconSize = smallIconSize
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = stringResource(id = R.string.Historico),
                    fontSize = subtitleFontSize,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.height(10.dp))

                Column(Modifier.verticalScroll(rememberScrollState())) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(colorResource(id = R.color.Cinza), RoundedCornerShape(8.dp))
                            .padding(8.dp, 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = "Bolacha Marinheira",
                                fontWeight = FontWeight.Bold,
                                color = colorResource(id = R.color.black),
                                fontSize = subtitleFontSize
                            )
                            Text(
                                text = " 26Cal, 1 bolacha",
                                color = colorResource(id = R.color.DarkGray),
                                fontSize = contentFontSize
                            )
                        }

                        Icon(
                            imageVector = Icons.Filled.AddCircle,
                            contentDescription = "Ver detalhes",
                            tint = Color(0xFFFF5722),
                            modifier = Modifier
                                .size(smallIconSize)
                                .clickable { }
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(colorResource(id = R.color.Cinza), RoundedCornerShape(8.dp))
                            .padding(8.dp, 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = "Bolacha Marinheira",
                                fontWeight = FontWeight.Bold,
                                color = colorResource(id = R.color.black),
                                fontSize = subtitleFontSize
                            )
                            Text(
                                text = " 26Cal, 1 bolacha",
                                color = colorResource(id = R.color.DarkGray),
                                fontSize = contentFontSize
                            )
                        }

                        Icon(
                            imageVector = Icons.Filled.AddCircle,
                            contentDescription = "Ver detalhes",
                            tint = Color(0xFFFF5722),
                            modifier = Modifier
                                .size(smallIconSize)
                                .clickable { }
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(colorResource(id = R.color.Cinza), RoundedCornerShape(8.dp))
                            .padding(8.dp, 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = "Bolacha Marinheira",
                                fontWeight = FontWeight.Bold,
                                color = colorResource(id = R.color.black),
                                fontSize = subtitleFontSize
                            )
                            Text(
                                text = " 26Cal, 1 bolacha",
                                color = colorResource(id = R.color.DarkGray),
                                fontSize = contentFontSize
                            )
                        }

                        Icon(
                            imageVector = Icons.Filled.AddCircle,
                            contentDescription = "Ver detalhes",
                            tint = Color(0xFFFF5722),
                            modifier = Modifier
                                .size(smallIconSize)
                                .clickable { }
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
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
fun AdiconarAlimentoPreview() {
    val navController = rememberNavController()
    AdiconarAlimento(navController = navController)
}
