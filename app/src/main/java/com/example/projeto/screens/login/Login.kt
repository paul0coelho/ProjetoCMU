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
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .padding(top = 20.dp, start = 10.dp, end = 10.dp),
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = colorResource(id = R.color.white),
                    titleContentColor = colorResource(id = R.color.black),
                    actionIconContentColor = colorResource(id = R.color.black)
                ),
                title = {
                    Text(
                        stringResource(id = R.string.Entrar),
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp)
                        },
                navigationIcon = {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = "Voltar",
                        modifier = Modifier.size(30.dp).clickable {
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
                    isPassword = false, fontSize = 1.sp, iconSize = 1.dp
                )

                CaixaTexto(
                    label = stringResource(id = R.string.Palavra_Passe),
                    value = password,
                    onValueChange = { password = it },
                    isPassword = true, fontSize = 1.sp, iconSize = 1.dp
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
                        fontSize = 18.sp
                    )
                }

                // Link para Recuperar Senha
                ClickableText(
                    text = AnnotatedString(stringResource(id = R.string.RecuperarPalavraPasse)),
                    style = TextStyle(color = colorResource(id = R.color.LaranjaGeral), fontSize = 15.sp, fontWeight = FontWeight.Bold),
                    onClick = {navController.navigate("RecuperarSenha")}
                )

                // Separador "OU"
                Text(
                    text = stringResource(id = R.string.Ou),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(vertical = 10.dp)
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth().clip(RoundedCornerShape(30.dp))
                        .shadow(
                            elevation = 8.dp,
                            shape = RoundedCornerShape(30.dp),
                            clip = false
                        )
                        .clickable {

                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(id = R.string.EntrarGoogle),
                        Modifier.padding(10.dp),
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth().clip(RoundedCornerShape(30.dp))
                        .shadow(
                            elevation = 8.dp,
                            shape = RoundedCornerShape(30.dp),
                            clip = false
                        )
                        .clickable {

                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(id = R.string.EntrarFacebook),
                        Modifier.padding(10.dp),
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp
                    )
                }
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
