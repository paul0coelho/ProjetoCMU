package com.example.projeto.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projeto.reuse.BottomNavigationBar
import com.example.projeto.reuse.Header
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projeto.R

@Composable
fun LoginScreen() {
    Scaffold(
        content= { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
               Text("Bem vindo ao", fontSize = 20.sp,fontWeight = FontWeight.Bold)
                Text("75 HARD", fontSize = 50.sp, color = Color(0xFFFF5722), fontWeight = FontWeight.Bold)
                Image(
                    painter = painterResource(id = R.drawable.logo75),
                    contentDescription = "Logo 75",
                    modifier = Modifier.fillMaxWidth()
                        .height(400.dp),
                    contentScale = ContentScale.Crop
                )
                Text("Está pronto para o desafio?", fontSize = 20.sp,fontWeight = FontWeight.Bold)
                Box(
                    modifier = Modifier
                        .fillMaxWidth().clip(RoundedCornerShape(16.dp))
                        .background(color = Color(0xFFFF5722))
                        .clickable {
                            // Ação ao clicar
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "REGISTAR-SE GRATUITAMENTE",
                        modifier = Modifier.padding(20.dp),
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp

                    )
                }
                ClickableText(
                    text = AnnotatedString("Entrar"),
                    modifier = Modifier.padding(20.dp),
                    style = TextStyle(
                        color = Color(0xFFFF5722),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    onClick = {}
                )
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
