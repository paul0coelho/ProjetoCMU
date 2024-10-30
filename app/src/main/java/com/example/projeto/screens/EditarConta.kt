package com.example.projeto.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projeto.reuse.CaixaTexto

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
    onButtonClick: () -> Unit
) {
    var nameState by remember { mutableStateOf(name) }
    var emailState by remember { mutableStateOf(email) }
    var genderState by remember { mutableStateOf(gender) }
    var birthDateState by remember { mutableStateOf(birthDate) }
    var phoneState by remember { mutableStateOf(phone) }
    var passwordState by remember { mutableStateOf("") }
    var confirmPasswordState by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = title, fontWeight = FontWeight.Bold, fontSize = 25.sp) },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier.size(30.dp),
                        tint = Color.Black
                    )
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color.Black,
                    actionIconContentColor = Color.Black
                )
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
                CaixaTexto(label = "Nome", value = nameState, onValueChange = { nameState = it })
                CaixaTexto(label = "Email", value = emailState, onValueChange = { emailState = it })
                CaixaTexto(label = "Gênero", value = genderState, onValueChange = { genderState = it })
                CaixaTexto(label = "Data de nascimento", value = birthDateState, onValueChange = { birthDateState = it })
                CaixaTexto(label = "Telemóvel", value = phoneState, onValueChange = { phoneState = it })
                CaixaTexto(label = "Senha", isPassword = true, value = passwordState, onValueChange = { passwordState = it })
                CaixaTexto(label = "Confirmar Senha", isPassword = true, value = confirmPasswordState, onValueChange = { confirmPasswordState = it })

                Spacer(modifier = Modifier.height(20.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(30.dp))
                        .background(Color(0xFFFF5722))
                        .clickable { onButtonClick() },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = buttonText,
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

@Composable
fun EditProfileScreen(
    name: String,
    email: String,
    gender: String,
    birthDate: String,
    phone: String
) {
    EditarContaScreen(
        title = "Editar Perfil",
        buttonText = "Guardar",
        name = name,
        email = email,
        gender = gender,
        birthDate = birthDate,
        phone = phone,
        onButtonClick = { /* Ação ao clicar em Guardar */ }
    )
}

@Preview(showBackground = true)
@Composable
fun EditProfileScreenPreview() {
    EditProfileScreen(
        name = "João Santos",
        email = "joao.santos@gmail.com",
        gender = "Masculino",
        birthDate = "01/01/1990",
        phone = "912345678"
    )
}
