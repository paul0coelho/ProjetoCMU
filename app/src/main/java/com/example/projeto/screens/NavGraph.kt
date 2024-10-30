package com.example.projeto.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "inicial") {
        composable("inicial") { InicialScreen(navController) }
        composable("login") { LoginScreen() }
    }
}
