package com.example.projeto.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.clickable
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.projeto.R


@Composable
fun InicialScreen(navController: NavHostController) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    val titleFontSize = (screenWidth.value * 0.07).sp
    val subtitleFontSize = (screenWidth.value * 0.05).sp
    val contentFontSize = (screenWidth.value * 0.04).sp
    val bigIconSize = (screenWidth.value * 0.07).dp
    val smallIconSize = (screenWidth.value * 0.06).dp
    Scaffold(
        content= { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Column(Modifier.weight(0.1f),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(10.dp,Alignment.CenterVertically)) {
                    Text(
                    stringResource(id = R.string.Bem_Vindo),
                    fontSize = contentFontSize,fontWeight = FontWeight.Bold
                )
                    Text("75 HARD", fontSize = titleFontSize, color = colorResource(id = R.color.LaranjaGeral), fontWeight = FontWeight.Bold)
                }

               Image(
                    painter = painterResource(id = R.drawable.logo75),
                    contentDescription = "Logo 75",
                    modifier = Modifier.fillMaxWidth().weight(0.7f)
                        .height((screenHeight.value*0.7).dp),
                    contentScale = ContentScale.Crop
                )
                Column(Modifier.weight(0.2f),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween) {
                    Text(
                        stringResource(id = R.string.Pergunta),
                        fontSize = contentFontSize,fontWeight = FontWeight.Bold
                    )
                    Box(
                        modifier = Modifier
                            .width((screenWidth.value*0.850).dp).height((screenHeight.value*0.06).dp).clip(RoundedCornerShape(16.dp))
                            .background(color = colorResource(id = R.color.LaranjaGeral))
                            .clickable {
                                // Ação ao clicar
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = stringResource(id = R.string.Registar),
                            modifier = Modifier.clickable {
                                navController.navigate("Registar")
                            },
                            color = colorResource(id = R.color.white),
                            fontWeight = FontWeight.Bold,
                            fontSize =  subtitleFontSize

                        )
                    }
                    Text(
                        text = stringResource(id = R.string.Entrar),
                        color = colorResource(id = R.color.LaranjaGeral),
                        fontSize =contentFontSize,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(16.dp).clickable {
                            navController.navigate("login")
                        }
                    )
                }

                }
            },
        containerColor = colorResource(id = R.color.white)
    )
}

@Preview(showBackground = true)
@Composable
fun InicialScreenPreview() {
    val navController = rememberNavController()
    InicialScreen(navController = navController)
}