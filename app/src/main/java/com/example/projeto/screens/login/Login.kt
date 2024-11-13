package com.example.projeto.screens.login

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.projeto.R
import com.example.projeto.reuse.CaixaTexto

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavHostController) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    val titleFontSize = (screenWidth.value * 0.07).sp
    val subtitleFontSize = (screenWidth.value * 0.05).sp
    val contentFontSize = (screenWidth.value * 0.04).sp
    val bigIconSize = (screenWidth.value * 0.07).dp
    val smallIconSize = (screenWidth.value * 0.06).dp
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .padding(10.dp),
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = colorResource(id = R.color.white),
                    titleContentColor = colorResource(id = R.color.black),
                    actionIconContentColor = colorResource(id = R.color.black)
                ),
                title = {
                    Text(
                        stringResource(id = R.string.Entrar),
                        fontWeight = FontWeight.Bold,
                        fontSize = titleFontSize)
                        },
                navigationIcon = {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = "Voltar",
                        modifier = Modifier.size(bigIconSize).clickable {
                            navController.navigate("inicial")
                        },
                        tint = colorResource(id = R.color.black)
                    )
                },
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                var email by remember { mutableStateOf("") }
                var password by remember { mutableStateOf("") }

                CaixaTexto(
                    label = stringResource(id = R.string.Email),
                    value = email,
                    onValueChange = { email = it },
                    isPassword = false, fontSize = subtitleFontSize, iconSize = smallIconSize
                )

                CaixaTexto(
                    label = stringResource(id = R.string.Palavra_Passe),
                    value = password,
                    onValueChange = { password = it },
                    isPassword = true, fontSize = subtitleFontSize, iconSize = smallIconSize
                )

                Spacer(modifier = Modifier.height(5.dp))

                Button(
                    onClick = { navController.navigate("Diario") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(30.dp)),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.LaranjaGeral))
                ) {
                    Text(
                        text = stringResource(id = R.string.Entrar),
                        color = colorResource(id = R.color.white),
                        fontWeight = FontWeight.Bold,
                        fontSize = subtitleFontSize
                    )
                }

                Text(
                    text = stringResource(id = R.string.RecuperarPalavraPasse),
                    color = colorResource(id = R.color.LaranjaGeral),
                    fontSize =contentFontSize,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp).clickable {
                        navController.navigate("RecuperarSenha")
                    }
                )

            }
        },
        containerColor = colorResource(id = R.color.white)
    )
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    val navController = rememberNavController()
    LoginScreen(navController = navController)
}
