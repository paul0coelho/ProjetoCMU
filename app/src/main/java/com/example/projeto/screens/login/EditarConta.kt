package com.example.projeto.screens.login

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
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
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditarContaScreen(
    title: String,
    buttonText: String,
    name: String = "",
    email: String = "",
    gender: String = "",
    birthDate: String = "",
    phone: String = "",
    onButtonClick: () -> Unit,
    navController: NavHostController
) {
    val context = LocalContext.current
    val db = Firebase.firestore
    var nameState by remember { mutableStateOf(name) }
    var emailState by remember { mutableStateOf(email) }
    var genderState by remember { mutableStateOf(gender) }
    var birthDateState by remember { mutableStateOf(birthDate) }
    var phoneState by remember { mutableStateOf(phone) }
    var passwordState by remember { mutableStateOf("") }
    var confirmPasswordState by remember { mutableStateOf("") }

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
                title = { Text(text = title, fontWeight = FontWeight.Bold, fontSize = titleFontSize) },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier.size(bigIconSize).clickable {
                            navController.navigate("More")
                        },
                        tint = colorResource(id = R.color.black)
                    )
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = colorResource(id = R.color.white),
                    titleContentColor = colorResource(id = R.color.black),
                    actionIconContentColor = colorResource(id = R.color.black)
                )
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues).padding(horizontal =((screenWidth.value*0.03).dp)).verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy((screenWidth.value*0.05).dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CaixaTexto(label = stringResource(id = R.string.Nome), value = nameState, onValueChange = { nameState = it },  fontSize = subtitleFontSize, iconSize = smallIconSize)
                CaixaTexto(label = stringResource(id = R.string.Email), value = emailState, onValueChange = { emailState = it },  fontSize = subtitleFontSize, iconSize = smallIconSize)
                CaixaTexto(label = stringResource(id = R.string.Genero), value = genderState, onValueChange = { genderState = it }, fontSize = subtitleFontSize, iconSize = smallIconSize)
                CaixaTexto(label = stringResource(id = R.string.DataNascimento), value = birthDateState, onValueChange = { birthDateState = it },  fontSize = subtitleFontSize, iconSize = smallIconSize)
                CaixaTexto(label = stringResource(id = R.string.Telemovel), value = phoneState, onValueChange = { phoneState = it }, fontSize = subtitleFontSize, iconSize = smallIconSize)
                CaixaTexto(label = stringResource(id = R.string.Senha), isPassword = true, value = passwordState, onValueChange = { passwordState = it }, fontSize = subtitleFontSize, iconSize = smallIconSize)
                CaixaTexto(label = stringResource(id = R.string.ConfirmarSenha), isPassword = true, value = confirmPasswordState, onValueChange = { confirmPasswordState = it }, fontSize = subtitleFontSize, iconSize = smallIconSize)

                Box(
                    modifier = Modifier
                        .fillMaxWidth().padding(bottom = 10.dp)
                        .clip(RoundedCornerShape(30.dp))
                        .background(colorResource(id = R.color.LaranjaGeral))
                        .clickable {
                            if (validarCampos(nameState, emailState, genderState, birthDateState, phoneState, passwordState, confirmPasswordState)) {
                                db.collection("Utilizadores")
                                    .document(emailState)
                                    .update(
                                        "nome", nameState,
                                        "email", emailState,
                                        "genero", genderState,
                                        "data_nascimento", birthDateState,
                                        "telemovel", phoneState,
                                        "senha", passwordState
                                    )
                                    .addOnSuccessListener {
                                        navController.navigate("login")
                                    }
                                    .addOnFailureListener {
                                        Toast.makeText(context, "Erro ao atualizar conta", Toast.LENGTH_SHORT).show()
                                    }

                            } else {
                                Toast.makeText(context, "Preencha todos os campos corretamente", Toast.LENGTH_SHORT).show()
                            }
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(id = R.string.Guardar),
                        modifier = Modifier.padding(15.dp),
                        color = colorResource(id = R.color.white),
                        fontWeight = FontWeight.Bold,
                        fontSize = subtitleFontSize
                    )
                }
            }
        },
        bottomBar = {
            BottomNavigationBar(navController, "Diario")
        },
        containerColor = colorResource(id = R.color.white)
    )
}

@Composable
fun EditProfileScreen(
    name: String,
    email: String,
    gender: String,
    birthDate: String,
    phone: String,
    navController: NavHostController
) {
    EditarContaScreen(
        title = stringResource(id = R.string.EditarPerfil),
        buttonText = stringResource(id = R.string.Guardar),
        name = name,
        email = email,
        gender = gender,
        birthDate = birthDate,
        phone = phone,
        onButtonClick = {},
        navController
    )
}

@Preview(showBackground = true)
@Composable
fun EditProfileScreenPreview() {
    val navController = rememberNavController()
    EditProfileScreen(
        name = "João Santos",
        email = "joao.santos@gmail.com",
        gender = "Masculino",
        birthDate = "01/01/1990",
        phone = "912345678",
        navController = navController
    )
}
