package com.example.projeto.screens.treino

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
import com.example.projeto.reuse.BottomNavigationBar
import com.example.projeto.reuse.CaixaTexto
import com.example.projeto.reuse.Header

@SuppressLint("UnrememberedMutableState", "UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CriarTreinoScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            Header(navController)
        },
        content = {
            Column(Modifier.padding(10.dp,80.dp).fillMaxHeight()) {
                Row (verticalAlignment = Alignment.CenterVertically){
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier.size(30.dp).clickable {
                            navController.popBackStack()
                        },
                        tint = Color.Black
                    )
                    Text(
                        text = "Criar Treino",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))
                var nome by remember { mutableStateOf("") }
                 CaixaTexto(
                    "Nome",
                    nome,
                    { novoNome -> nome = novoNome },
                )
                var tipo by remember { mutableStateOf("") }
                CaixaTexto(
                    "Tipo",
                    tipo,
                    { novoNome -> tipo = novoNome },
                )
                var duracao by remember { mutableStateOf("") }
                CaixaTexto(
                    "Duração",
                    duracao,
                    { novoNome -> duracao = novoNome },
                )
                var inicial by remember { mutableStateOf("") }
                CaixaTexto(
                    "Local Inicial",
                    inicial,
                    { novoNome -> inicial = novoNome },
                )
                var final by remember { mutableStateOf("") }
                CaixaTexto(
                    "Local Final",
                    final,
                    { novoNome -> final = novoNome },
                )
                var data by remember { mutableStateOf("") }
                CaixaTexto(
                    "Data de Início",
                    data,
                    { novoNome -> data = novoNome },
                )
                var hora by remember { mutableStateOf("") }
                CaixaTexto(
                    "Hora de Início",
                    hora,
                    { novoNome -> hora = novoNome },
                )

            }
        },
            bottomBar = {
                BottomNavigationBar(navController)
            },
        containerColor = Color.White
    )
}

@Preview(showBackground = true)
@Composable
fun CriarTreinoScreenPreview() {
    val navController = rememberNavController()
    CriarTreinoScreen(navController = navController)
}
