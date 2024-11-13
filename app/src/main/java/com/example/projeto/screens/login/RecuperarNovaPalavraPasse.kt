package com.example.projeto.screens.login

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.projeto.R
import com.example.projeto.reuse.CaixaTexto

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RecuperarNovaPalavraPasse(navController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var novaSenha by remember { mutableStateOf("") }
    var confirmeSenha by remember { mutableStateOf("") }


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
            TopAppBar(modifier = Modifier.padding(10.dp),
                title = {
                    Text(
                        text = stringResource(id = R.string.RecuperarPalavraPasse),
                        fontSize = titleFontSize,
                        fontWeight = FontWeight.Bold,
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("RecuperarSenha") }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Voltar",
                            modifier = Modifier.size(bigIconSize),
                            tint = colorResource(id = R.color.black)
                        )
                    }
                },
            )
        },
        content = {paddingValues->
            Spacer(Modifier.height((screenHeight.value*0.1).dp))
            Column(
                modifier = Modifier
                    .padding(paddingValues).padding((screenWidth.value*0.03).dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {

                CaixaTexto(
                    label = stringResource(id = R.string.Email),
                    value = email,
                    onValueChange = { email = it }, fontSize =subtitleFontSize, iconSize = smallIconSize
                )

                CaixaTexto(
                    label = stringResource(id = R.string.NovaPalavraPasse),
                    value = novaSenha,
                    onValueChange = { novaSenha = it },
                    isPassword = true, fontSize =subtitleFontSize, iconSize = smallIconSize
                )

                CaixaTexto(
                    label = stringResource(id = R.string.ConfirmeNovaPalavraPasse),
                    value = confirmeSenha,
                    onValueChange = { confirmeSenha = it },
                    isPassword = true,  fontSize =subtitleFontSize, iconSize = smallIconSize
                )

                // Botão para alterar a palavra-passe
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                        .background(color = colorResource(id = R.color.LaranjaGeral))
                        .clickable { navController.navigate("login")
                                   /* Ação ao clicar */ },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(id = R.string.AlterarPalavraPasse),
                        modifier = Modifier.padding(16.dp),
                        color = colorResource(id = R.color.white),
                        fontWeight = FontWeight.Bold,
                        fontSize =subtitleFontSize
                    )
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun RecuperarNovaPalavraPassePreview() {
    val navController = rememberNavController()
    RecuperarNovaPalavraPasse(navController = navController)
}
