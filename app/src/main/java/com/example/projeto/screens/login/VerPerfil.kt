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
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.projeto.R
import com.example.projeto.reuse.BottomNavigationBar
import com.example.projeto.reuse.CaixaTexto
import com.example.projeto.reuse.Header

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PerfilScreen(navController: NavHostController) {
    Scaffold(
            topBar = {
                Header(navController)
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
                // Foto do perfil
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .background(colorResource(id = R.color.Gray), shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = "Foto de perfil",
                        tint = colorResource(id = R.color.white),
                        modifier = Modifier.size(60.dp)
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Dados do perfil com campos desabilitados
                var nome by remember { mutableStateOf("Nome do Usuário") }
                CaixaTexto(
                    label = stringResource(id = R.string.Nome),
                    value = nome,
                    onValueChange = { nome = it },
                    enabled = false // Campo desabilitado
                )

                var email by remember { mutableStateOf("email@exemplo.com") }
                CaixaTexto(
                    label = stringResource(id = R.string.Email),
                    value = email,
                    onValueChange = { email = it },
                    enabled = false
                )

                var genero by remember { mutableStateOf("Gênero") }
                CaixaTexto(
                    label = stringResource(id = R.string.Genero),
                    value = genero,
                    onValueChange = { genero = it },
                    enabled = false
                )

                var dataNascimento by remember { mutableStateOf("01/01/2000") }
                CaixaTexto(
                    label = stringResource(id = R.string.DataNascimento),
                    value = dataNascimento,
                    onValueChange = { dataNascimento = it },
                    enabled = false
                )

                var telefone by remember { mutableStateOf("123456789") }
                CaixaTexto(
                    label = stringResource(id = R.string.Telemovel),
                    value = telefone,
                    onValueChange = { telefone = it },
                    enabled = false
                )

                Spacer(modifier = Modifier.height(10.dp))
            }
        },
        containerColor = colorResource(id = R.color.white),
        bottomBar = {
            BottomNavigationBar(navController, "More")
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PerfilScreenPreview() {
    val navController = rememberNavController()
    PerfilScreen(navController = navController)
}
