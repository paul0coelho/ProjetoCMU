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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.projeto.R
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
                        tint = colorResource(id = R.color.black)
                    )
                    Text(
                        text = stringResource(id = R.string.CriarTreino),
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))
                var nome by remember { mutableStateOf("") }
                 CaixaTexto(
                     stringResource(id = R.string.Nome),
                    nome,
                    { novoNome -> nome = novoNome },
                )
                var tipo by remember { mutableStateOf("") }
                CaixaTexto(
                    stringResource(id = R.string.Tipo),
                    tipo,
                    { novoNome -> tipo = novoNome },
                )
                var duracao by remember { mutableStateOf("") }
                CaixaTexto(
                    stringResource(id = R.string.Duracao),
                    duracao,
                    { novoNome -> duracao = novoNome },
                )
                var inicial by remember { mutableStateOf("") }
                CaixaTexto(
                    stringResource(id = R.string.LocalInicial),
                    inicial,
                    { novoNome -> inicial = novoNome },
                )
                var final by remember { mutableStateOf("") }
                CaixaTexto(
                    stringResource(id = R.string.LocalFinal),
                    final,
                    { novoNome -> final = novoNome },
                )
                var data by remember { mutableStateOf("") }
                CaixaTexto(
                    stringResource(id = R.string.DataInicio),
                    data,
                    { novoNome -> data = novoNome },
                )
                var hora by remember { mutableStateOf("") }
                CaixaTexto(
                    stringResource(id = R.string.HoraInicio),
                    hora,
                    { novoNome -> hora = novoNome },
                )

            }
        },
            bottomBar = {
                BottomNavigationBar(navController)
            },
        containerColor = colorResource(id = R.color.white)
    )
}

@Preview(showBackground = true)
@Composable
fun CriarTreinoScreenPreview() {
    val navController = rememberNavController()
    CriarTreinoScreen(navController = navController)
}
