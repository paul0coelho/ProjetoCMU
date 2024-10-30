package com.example.projeto.reuse

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    NavigationBar(
        containerColor = Color.Black,
        contentColor = Color.White
    ) {
        NavigationBarItem(
            icon = { Text(text = "75", color = Color(0xFFFF5722), fontWeight = FontWeight.Bold) },
            label = { Text("Desafio", color = Color(0xFFFF5722)) },
            selected = false,
            onClick = {navController.navigate("Desafio")}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Default.Menu,
                    contentDescription = "Diary",
                    tint = Color(0xFFFF5722)
                )
            },
            label = { Text("Diário", color = Color.White) },
            selected = true,
            onClick = {navController.navigate("Diario")}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Default.MoreVert,
                    contentDescription = "More",
                    tint = Color(0xFFFF5722)
                )
            },
            label = { Text("More", color = Color(0xFFFF5722)) },
            selected = false,
            onClick = {navController.navigate("More")}
        )
    }
}