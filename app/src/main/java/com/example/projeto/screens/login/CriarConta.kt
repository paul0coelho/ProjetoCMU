package com.example.projeto.screens.login

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.telecom.Call
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.projeto.API.RetrofitHelper
import com.example.projeto.R
import com.example.projeto.reuse.CaixaTexto
import com.example.projeto.room.AppDatabase
import com.example.projeto.room.entities.Utilizador
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.Date
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalConfiguration
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.launch


@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CriarContaScreen(navController: NavHostController) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val db = Firebase.firestore

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
                modifier = Modifier.padding(10.dp),
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = colorResource(id = R.color.white),
                    titleContentColor = colorResource(id = R.color.black),
                    actionIconContentColor = colorResource(id = R.color.black)
                ),
                title = {
                    Text(
                        stringResource(id = R.string.CriarConta),
                        fontWeight = FontWeight.Bold,
                        fontSize = titleFontSize)
                        },
                navigationIcon = {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = "Voltar",
                        modifier = Modifier.size(bigIconSize).clickable {
                            navController.navigate("login")
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
                    .padding(15.dp).verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size((screenHeight.value*0.1).dp)
                        .background(colorResource(id = R.color.Gray), shape = CircleShape)
                        .clickable { /* Ação para adicionar foto */ },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = "Adicionar foto de perfil",
                        tint = colorResource(id = R.color.white),
                        modifier = Modifier.size((screenHeight.value*0.1).dp)
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                var nome by remember { mutableStateOf("") }
                CaixaTexto(
                    label = stringResource(id = R.string.Nome),
                    value = nome,
                    onValueChange = { nome = it }, fontSize = subtitleFontSize, iconSize = smallIconSize
                )

                var email by remember { mutableStateOf("") }
                CaixaTexto(
                    label = stringResource(id = R.string.Email),
                    value = email,
                    onValueChange = { email = it }, fontSize = subtitleFontSize, iconSize = smallIconSize
                )

                var genero by remember { mutableStateOf("") }
                CaixaTexto(
                    label = stringResource(id = R.string.Genero),
                    value = genero,
                    onValueChange = { genero = it }, fontSize = subtitleFontSize, iconSize = smallIconSize
                )

                var dataNascimento by remember { mutableStateOf("") }
                CaixaTexto(
                    label = stringResource(id = R.string.DataNascimento),
                    value = dataNascimento,
                    onValueChange = { dataNascimento = it }, fontSize = subtitleFontSize, iconSize = smallIconSize
                )

                var telefone by remember { mutableStateOf("") }
                CaixaTexto(
                    label = stringResource(id = R.string.Telemovel),
                    value = telefone,
                    onValueChange = { telefone = it }, fontSize = subtitleFontSize, iconSize = smallIconSize
                )

                var senha by remember { mutableStateOf("") }
                CaixaTexto(
                    label = stringResource(id = R.string.Senha),
                    value = senha,
                    onValueChange = { senha = it },
                    isPassword = true, fontSize = subtitleFontSize, iconSize = smallIconSize
                )

                var confirmarSenha by remember { mutableStateOf("") }
                CaixaTexto(
                    label = stringResource(id = R.string.ConfirmarSenha),
                    value = confirmarSenha,
                    onValueChange = { confirmarSenha = it },
                    isPassword = true, fontSize = subtitleFontSize, iconSize = smallIconSize
                )

                Spacer(modifier = Modifier.height(10.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(30.dp))
                        .background(color = colorResource(id = R.color.LaranjaGeral))
                        .clickable {
                            if (validarCampos(nome, email, genero, dataNascimento, telefone, senha, confirmarSenha)) {
                                val utilizador = hashMapOf(
                                    "nome" to nome,
                                    "email" to email,
                                    "genero" to genero,
                                    "data_nascimento" to dataNascimento,
                                    "telemovel" to telefone,
                                    "senha" to senha,
                                    "dataRegisto" to SimpleDateFormat("dd/MM/yyyy").format(Date()),
                                    "maximoStreak" to 0,
                                    "streakAtual" to 0
                                )

                                db.collection("Utilizadores")
                                    .document(email)
                                    .set(utilizador)
                                    .addOnSuccessListener {
                                        navController.navigate("login")
                                    }
                                    .addOnFailureListener {
                                        Toast.makeText(context, "Erro ao criar conta", Toast.LENGTH_SHORT).show()
                                    }
                            } else {
                                Toast.makeText(context, "Preencha todos os campos corretamente", Toast.LENGTH_SHORT).show()
                            }
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(id = R.string.Criar),
                        modifier = Modifier.padding(15.dp),
                        color = colorResource(id = R.color.white),
                        fontWeight = FontWeight.Bold,
                        fontSize = subtitleFontSize
                    )
                }
            }
        },
        containerColor = colorResource(id = R.color.white)
    )
}

fun validarCampos(nome: String, email: String, genero: String, dataNascimento: String, telefone: String, senha: String,
    confirmarSenha: String): Boolean {
    if (nome.isEmpty() || email.isEmpty() || genero.isEmpty() || dataNascimento.isEmpty() || telefone.isEmpty() || senha.isEmpty() || confirmarSenha.isEmpty()) {
        return false
    }

    if (senha != confirmarSenha) {
        return false
    }

    val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$".toRegex()
    if (!email.matches(emailRegex)) {
        return false
    }

    if (telefone.any { !it.isDigit() }) {
        return false
    }

    if (telefone.length != 9) {
        return false
    }

    try {
        val sdf = SimpleDateFormat("dd/MM/yyyy")
        sdf.isLenient = false
        sdf.parse(dataNascimento)
    } catch (e: Exception) {
        return false
    }

    if (senha.length < 6) {
        return false
    }
    return true
}



@Preview(showBackground = true)
@Composable
fun CriarContaScreenPreview() {
    val navController = rememberNavController()
    CriarContaScreen(navController = navController)
}
