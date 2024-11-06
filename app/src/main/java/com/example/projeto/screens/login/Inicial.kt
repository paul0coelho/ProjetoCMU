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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.projeto.R


@Composable
fun InicialScreen(navController: NavHostController) {
    Scaffold(
        content= { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
               Text(
                   stringResource(id = R.string.Bem_Vindo),
                   fontSize = 20.sp,fontWeight = FontWeight.Bold
               )
                Text("75 HARD", fontSize = 50.sp, color = colorResource(id = R.color.LaranjaGeral), fontWeight = FontWeight.Bold)
                Image(
                    painter = painterResource(id = R.drawable.logo75),
                    contentDescription = "Logo 75",
                    modifier = Modifier.fillMaxWidth()
                        .height(400.dp),
                    contentScale = ContentScale.Crop
                )
                Text(
                    stringResource(id = R.string.Pergunta),
                    fontSize = 20.sp,fontWeight = FontWeight.Bold
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth().clip(RoundedCornerShape(16.dp))
                        .background(color = colorResource(id = R.color.LaranjaGeral))
                        .clickable {
                            // Ação ao clicar
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(id = R.string.Registar),
                        modifier = Modifier.padding(20.dp).clickable {
                            navController.navigate("Registar")
                        },
                        color = colorResource(id = R.color.white),
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp

                    )
                }
                Text(
                    text = stringResource(id = R.string.Entrar),
                    color = colorResource(id = R.color.LaranjaGeral),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp).clickable {
                        navController.navigate("login")
                    }
                )
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