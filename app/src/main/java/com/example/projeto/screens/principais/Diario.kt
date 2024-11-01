package com.example.projeto.screens.principais

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.projeto.reuse.BottomNavigationBar
import com.example.projeto.reuse.Header

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiaryScreen(navController: NavHostController) {
    Scaffold(
        topBar = { Header(navController) },
        content= { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(color = Color.White),
                verticalArrangement = Arrangement.spacedBy(20.dp),
            ) {

                Column(Modifier.align(Alignment.CenterHorizontally)) {
                    Text(
                    "Foto do dia",
                        Modifier.fillMaxWidth(),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    fontSize = 25.sp
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth().height(height = 250.dp).padding(horizontal = 35.dp).padding(vertical = 10.dp)
                            .clip(RoundedCornerShape(30.dp))
                            .background(color = Color(0xFFFF5722))
                            .clickable {
                                // Ação ao clicar
                            },
                        contentAlignment = Alignment.Center
                    ) {}
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth().fillMaxHeight().padding(horizontal = 20.dp).align(Alignment.CenterHorizontally),
                    contentAlignment = Alignment.Center
                ) {
                    Column(Modifier.fillMaxSize().align(Alignment.Center),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(16.dp),
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            section("Calorias","500 restantes",navController,"Calorias")
                            section("Água","1,5/3L",navController,"IngestaoAgua")
                        }
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(16.dp),
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            section("Páginas Lidas","3/10",navController,"Livros")
                            section("Treinos","0/2",navController,"Treinos")
                        }
                    }
                }
            }
        } ,
        bottomBar = { BottomNavigationBar(navController) },
        containerColor = Color.White
    )
}

@Composable
fun section(title:String,content:String,navController: NavHostController,route:String){
    Box(
        Modifier
            .height(160.dp).width(160.dp)
            .clip(RoundedCornerShape(30.dp))
            .clickable {
                navController.navigate(route)
            },
        contentAlignment = Alignment.Center
    ) {
        Column(Modifier.background(color = Color(0xFFEEEEF0)).fillMaxHeight()) {
            Text(modifier = Modifier.fillMaxWidth().weight(.4f).padding(top = 15.dp),text = title, fontWeight = FontWeight.Bold, fontSize = 20.sp, textAlign = TextAlign.Center)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1.4f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = content,
                    fontWeight = FontWeight.Bold,
                    fontSize = 35.sp,
                    color = Color(0xFFFF5722),
                    textAlign = TextAlign.Center
                )
            }}
    }
}


@Preview(showBackground = true)
@Composable
fun DiaryScreenPreview() {
    val navController = rememberNavController()

    DiaryScreen(navController = navController)
}