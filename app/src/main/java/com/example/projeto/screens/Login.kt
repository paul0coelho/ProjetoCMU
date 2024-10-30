package com.example.projeto.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
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
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projeto.reuse.CaixaTexto

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .padding(top = 20.dp, start = 10.dp, end = 10.dp),
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color.Black,
                    actionIconContentColor = Color.Black
                ),
                title = { Text("Entrar", fontWeight = FontWeight.Bold, fontSize = 25.sp) },
                navigationIcon = {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = "Voltar",
                        modifier = Modifier.size(30.dp),
                        tint = Color.Black
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

                // Campo de Email usando CaixaTexto
                CaixaTexto(
                    label = "Email",
                    value = email,
                    onValueChange = { email = it },
                    isPassword = false
                )

                // Campo de Senha usando CaixaTexto
                CaixaTexto(
                    label = "Palavra-Passe",
                    value = password,
                    onValueChange = { password = it },
                    isPassword = true
                )

                Spacer(modifier = Modifier.height(5.dp))

                // Botão Entrar
                Button(
                    onClick = { /* Ação ao clicar */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(30.dp)),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF5722))
                ) {
                    Text(
                        text = "Entrar",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }

                // Link para Recuperar Senha
                ClickableText(
                    text = AnnotatedString("Recuperar Palavra-Passe"),
                    style = TextStyle(color = Color(0xFFFF5722), fontSize = 15.sp, fontWeight = FontWeight.Bold),
                    onClick = {}
                )

                // Separador "OU"
                Text(
                    text = "OU",
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
                        text = "Entrar com o Google",
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
                        text = "Entrar com o Facebook",
                        Modifier.padding(10.dp),
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp
                    )
                }
            }
        },
        containerColor = Color.White
    )
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}

