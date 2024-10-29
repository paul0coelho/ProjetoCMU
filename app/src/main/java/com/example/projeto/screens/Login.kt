package com.example.projeto.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.Visibility
import com.example.projeto.R

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {
    Scaffold(
        topBar = {
            TopAppBar(modifier = Modifier.padding(top = 20.dp).padding(horizontal = 10.dp),
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color.Black,
                    actionIconContentColor = Color.Black

                ),
                title = { Text("Entrar", fontWeight = FontWeight.Bold, fontSize = 25.sp) },
                navigationIcon = {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = "Profile",
                        modifier = Modifier.size(30.dp),
                        tint = Color.Black
                    )
                },
           )
        },
        content= { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
            ) {
                var email by remember { mutableStateOf("") }
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = {
                        Text(
                            text = "Email",
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    },
                    modifier = Modifier
                    .fillMaxWidth(),
                    textStyle = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Black
                    ),
                    shape = MaterialTheme.shapes.small,
                    singleLine = true
                 )


                var password by remember { mutableStateOf("") }
                var passwordVisible by remember { mutableStateOf(false) }
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = {
                        Text(
                            text = "Palavra-Passe",
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    textStyle = TextStyle(
                        fontSize = 16.sp,
                        color = Color.Black
                    ),
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        val image = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                        Icon(
                            imageVector = image,
                            contentDescription = if (passwordVisible) "Ocultar senha" else "Mostrar senha",
                            modifier = Modifier
                                .size(24.dp)
                                .clickable { passwordVisible = !passwordVisible }
                        )
                    },
                    shape = MaterialTheme.shapes.small,
                    singleLine = true
                )
                Spacer(modifier = Modifier.height(5.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth().clip(RoundedCornerShape(30.dp))
                        .background(color = Color(0xFFFF5722))
                        .clickable {
                            // Ação ao clicar
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Entrar",
                        modifier = Modifier.padding(10.dp),
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp

                    )
                }
                ClickableText(
                    text = AnnotatedString("Recuperar Palavra-Passe"),
                    modifier = Modifier.padding(20.dp).align(alignment =Alignment.CenterHorizontally),
                    style = TextStyle(
                        color = Color(0xFFFF5722),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    onClick = {}
                )
                Text(
                    text = "OU",
                    modifier = Modifier.padding(10.dp).align(alignment = Alignment.CenterHorizontally),
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
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