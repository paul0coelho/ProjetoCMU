package com.example.projeto.screens.login

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.projeto.reuse.CaixaTexto

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CriarContaScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(horizontal = 10.dp),
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color.Black,
                    actionIconContentColor = Color.Black
                ),
                title = { Text("Criar Conta", fontWeight = FontWeight.Bold, fontSize = 25.sp) },
                navigationIcon = {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = "Voltar",
                        modifier = Modifier.size(30.dp).clickable {
                            navController.navigate("login")
                        },
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
                    .padding(15.dp),
                verticalArrangement = Arrangement.spacedBy(5.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color.Gray, shape = CircleShape)
                        .clickable { /* Ação para adicionar foto */ },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = "Adicionar foto de perfil",
                        tint = Color.White,
                        modifier = Modifier.size(60.dp)
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                var nome by remember { mutableStateOf("") }
                CaixaTexto(
                    label = "Nome",
                    value = nome,
                    onValueChange = { nome = it }
                )

                var email by remember { mutableStateOf("") }
                CaixaTexto(
                    label = "Email",
                    value = email,
                    onValueChange = { email = it }
                )

                var genero by remember { mutableStateOf("") }
                CaixaTexto(
                    label = "Gênero",
                    value = genero,
                    onValueChange = { genero = it }
                )

                var dataNascimento by remember { mutableStateOf("") }
                CaixaTexto(
                    label = "Data de nascimento",
                    value = dataNascimento,
                    onValueChange = { dataNascimento = it }
                )

                var telefone by remember { mutableStateOf("") }
                CaixaTexto(
                    label = "Telemóvel",
                    value = telefone,
                    onValueChange = { telefone = it }
                )

                var senha by remember { mutableStateOf("") }
                CaixaTexto(
                    label = "Senha",
                    value = senha,
                    onValueChange = { senha = it },
                    isPassword = true
                )

                var confirmarSenha by remember { mutableStateOf("") }
                CaixaTexto(
                    label = "Confirmar senha",
                    value = confirmarSenha,
                    onValueChange = { confirmarSenha = it },
                    isPassword = true
                )

                Spacer(modifier = Modifier.height(10.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(30.dp))
                        .background(color = Color(0xFFFF5722))
                        .clickable {
                            // Ação ao clicar em "Criar"
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Criar",
                        modifier = Modifier.padding(15.dp),
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }
            }
        },
        containerColor = Color.White
    )
}

@Preview(showBackground = true)
@Composable
fun CriarContaScreenPreview() {
    val navController = rememberNavController()
    CriarContaScreen(navController = navController)
}
