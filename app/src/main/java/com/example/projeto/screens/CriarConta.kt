package com.example.projeto.screens

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
import com.example.projeto.reuse.CaixaTexto

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CriarContaScreen() {
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
                    .padding(15.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Espaço para a foto de perfil
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

                Spacer(modifier = Modifier.height(12.dp))

                // Campo de nome
                var nome by remember { mutableStateOf("") }
                CaixaTexto(
                    label = "Nome",
                    value = nome,
                    onValueChange = { nome = it }
                )

                // Campo de email
                var email by remember { mutableStateOf("") }
                CaixaTexto(
                    label = "Email",
                    value = email,
                    onValueChange = { email = it }
                )

                // Campo de gênero
                var genero by remember { mutableStateOf("") }
                CaixaTexto(
                    label = "Gênero",
                    value = genero,
                    onValueChange = { genero = it }
                )

                // Campo de data de nascimento
                var dataNascimento by remember { mutableStateOf("") }
                CaixaTexto(
                    label = "Data de nascimento",
                    value = dataNascimento,
                    onValueChange = { dataNascimento = it }
                )

                // Campo de telefone
                var telefone by remember { mutableStateOf("") }
                CaixaTexto(
                    label = "Telemóvel",
                    value = telefone,
                    onValueChange = { telefone = it }
                )

                // Campo de senha
                var senha by remember { mutableStateOf("") }
                CaixaTexto(
                    label = "Senha",
                    value = senha,
                    onValueChange = { senha = it },
                    isPassword = true
                )

                // Campo de confirmação de senha
                var confirmarSenha by remember { mutableStateOf("") }
                CaixaTexto(
                    label = "Confirmar senha",
                    value = confirmarSenha,
                    onValueChange = { confirmarSenha = it },
                    isPassword = true
                )

                Spacer(modifier = Modifier.height(10.dp))

                // Botão Criar Conta
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
    CriarContaScreen()
}
