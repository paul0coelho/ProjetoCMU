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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import com.example.projeto.R

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    NavigationBar(
        containerColor = colorResource(id = R.color.black),
        contentColor = colorResource(id = R.color.white)
    ) {
        NavigationBarItem(
            icon = { Text(text = "75", color = colorResource(id = R.color.LaranjaGeral), fontWeight = FontWeight.Bold) },
            label = { Text(stringResource(id = R.string.Desafio), color = colorResource(id = R.color.LaranjaGeral)) },
            selected = false,
            onClick = {navController.navigate("Desafio")}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Default.Menu,
                    contentDescription = "Diary",
                    tint = colorResource(id = R.color.LaranjaGeral)
                )
            },
            label = { Text(stringResource(id = R.string.Diario), color = colorResource(id = R.color.white)) },
            selected = true,
            onClick = {navController.navigate("Diario")}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Default.MoreVert,
                    contentDescription = "More",
                    tint = colorResource(id = R.color.LaranjaGeral)
                )
            },
            label = { Text(stringResource(id = R.string.Mais), color = colorResource(id = R.color.LaranjaGeral)) },
            selected = false,
            onClick = {navController.navigate("More")}
        )
    }
}