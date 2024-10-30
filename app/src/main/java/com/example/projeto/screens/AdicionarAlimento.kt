package com.example.projeto.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projeto.R
import com.example.projeto.reuse.BottomNavigationBar
import com.example.projeto.reuse.Header

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AdiconarAlimento() {
    Scaffold(
        topBar = {
            Header()
        },
        content = {
            Column(modifier = Modifier.padding(10.dp, 80.dp)) {
                Text(
                    text = "Alimentos",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                )

                Spacer(modifier = Modifier.height(10.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .background(Color.LightGray, RoundedCornerShape(10.dp))
                    ){
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Ver detalhes",
                        tint = Color(0xFFFF5722),
                        modifier = Modifier.size(50.dp).clickable {}.align(Alignment.CenterStart).padding(10.dp,0.dp)
                    )
                    Text(
                        text = "Pesquisar",
                        fontWeight = FontWeight.Medium,
                        color = Color.DarkGray,
                        modifier = Modifier.align(Alignment.CenterStart).padding(50.dp,0.dp)
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Histórico",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.height(10.dp))

                Column {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp)
                                .background(Color.LightGray, RoundedCornerShape(8.dp))
                                .padding(8.dp, 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(
                                modifier = Modifier.weight(1f)
                            ) {
                                Text(
                                    text = "Bolacha Marinheira",
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )
                                Text(
                                    text = " 26Cal, 1 bolacha",
                                    color = Color.DarkGray,
                                    fontSize = 14.sp
                                )
                            }

                            Icon(
                                imageVector = Icons.Filled.AddCircle,
                                contentDescription = "Ver detalhes",
                                tint = Color(0xFFFF5722),
                                modifier = Modifier
                                    .size(24.dp)
                                    .clickable { }
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))

                }
            }
            },
        bottomBar = {
            BottomNavigationBar()
        },
        containerColor = Color.White
    )
}

@Preview(showBackground = true)
@Composable
fun AdiconarAlimentoPreview() {
    AdiconarAlimento()
}
