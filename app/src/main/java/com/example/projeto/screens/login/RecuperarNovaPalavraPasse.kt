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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.projeto.reuse.CaixaTexto

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RecuperarNovaPalavraPasse(navController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var novaSenha by remember { mutableStateOf("") }
    var confirmeSenha by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Recuperar Palavra-Passe",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(10.dp, 20.dp)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("RecuperarSenha") }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Voltar",
                            modifier = Modifier.size(30.dp),
                            tint = Color.Black
                        )
                    }
                },
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 80.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {

                CaixaTexto(
                    label = "Email",
                    value = email,
                    onValueChange = { email = it }
                )

                CaixaTexto(
                    label = "Nova Palavra-Passe",
                    value = novaSenha,
                    onValueChange = { novaSenha = it },
                    isPassword = true
                )

                CaixaTexto(
                    label = "Confirme Nova Palavra-Passe",
                    value = confirmeSenha,
                    onValueChange = { confirmeSenha = it },
                    isPassword = true
                )

                // Botão para alterar a palavra-passe
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                        .background(color = Color(0xFFFF5722))
                        .clickable { navController.navigate("login")
                                   /* Ação ao clicar */ },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Alterar Palavra-Passe",
                        modifier = Modifier.padding(16.dp),
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
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
