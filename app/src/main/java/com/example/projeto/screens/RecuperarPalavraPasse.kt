package com.example.projeto.screens

import android.annotation.SuppressLint
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
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
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

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RecuperarPalavraPasse() {
    Scaffold(
        topBar = {
            Text(
                text = "Recuperar Palavra-Passe",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp, 20.dp)
            )
        },
        content = {
            Column(modifier = Modifier.padding(10.dp, 80.dp)) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .background(Color.LightGray, RoundedCornerShape(10.dp))
                ){
                    Text(
                        text = "Email",
                        fontWeight = FontWeight.Medium,
                        color = Color.DarkGray,
                        modifier = Modifier.align(Alignment.CenterStart).padding(20.dp,0.dp)
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Por favor, insira o email associado à sua conta para procedermos ao envio de um código de reposição de palavra passe",
                    fontSize = 14.sp,
                    color = Color.DarkGray,
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                )

                Spacer(modifier = Modifier.height(20.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth().clip(RoundedCornerShape(16.dp))
                        .background(color = Color(0xFFFF5722))
                        .clickable {
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Solicitar Código",
                        modifier = Modifier.padding(20.dp),
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
fun RecuperarPalavraPassePreview() {
    RecuperarPalavraPasse()
}