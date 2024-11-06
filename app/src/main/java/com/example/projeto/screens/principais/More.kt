package com.example.projeto.screens.principais

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.material.icons.filled.Leaderboard
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.os.LocaleListCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.projeto.R
import com.example.projeto.reuse.BottomNavigationBar
import com.example.projeto.reuse.Header

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun More(navController: NavHostController) {
    Scaffold(
        topBar = {
            Header(navController)
        },
        content = {
            Column(modifier = Modifier.padding(10.dp, 80.dp)) {
                val menuItems = listOf(
                    Triple(Icons.Default.AccountCircle, stringResource(id = R.string.EditarPerfil),"EditarConta"),
                    Triple(Icons.Default.History, stringResource(id = R.string.Historico),"EvolucaoFotos"),
                    Triple(Icons.Default.Calculate, stringResource(id = R.string.Calorias),"Calorias"),
                    Triple(Icons.Default.Book, stringResource(id = R.string.Livros),"Livros"),
                    Triple(Icons.Default.FitnessCenter, stringResource(id = R.string.Treinos),"Treinos"),
                    Triple(Icons.Default.WaterDrop, stringResource(id = R.string.Agua),"IngestaoAgua"),
                    Triple(Icons.Default.Leaderboard, stringResource(id = R.string.LeaderBoard),"LeaderBoard"),
                    Triple(Icons.Default.Image, stringResource(id = R.string.EvolucaoFotos),"EvolucaoFotos"),
                    Triple(Icons.Default.Settings, stringResource(id = R.string.Definicoes),"Definicoes")
                )

                menuItems.forEach { item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .background(colorResource(id = R.color.CinzaClaro), RoundedCornerShape(8.dp))
                            .padding(8.dp, 4.dp)
                            .clickable { navController.navigate(item.third) },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = item.first,
                            contentDescription = item.second,
                            tint = colorResource(id = R.color.LaranjaGeral),
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(
                            text = item.second,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.black)
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                }
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
fun MorePreview() {
    val navController = rememberNavController()
    More(navController = navController)
}
