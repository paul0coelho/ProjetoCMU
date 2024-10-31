package com.example.projeto.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.projeto.screens.alimento.AdiconarAlimento
import com.example.projeto.screens.principais.DiaryScreen
import com.example.projeto.screens.login.CriarContaScreen
import com.example.projeto.screens.login.EditarContaScreen
import com.example.projeto.screens.login.InicialScreen
import com.example.projeto.screens.login.LoginScreen
import com.example.projeto.screens.login.RecuperarNovaPalavraPasse
import com.example.projeto.screens.login.RecuperarPalavraPasse

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "inicial") {
        composable("inicial") { InicialScreen(navController) }
        composable("login") { LoginScreen(navController) }
        composable("Registar") { CriarContaScreen(navController) }
        //composable("EditarConta") { EditarContaScreen(navController) }
        composable("RecuperarSenha") { RecuperarPalavraPasse(navController) }
        composable("RecuperarSenhaConfirmacao") { RecuperarNovaPalavraPasse(navController) }

        //composable("Desafio") { Desafio(navController) }
        //composable("LeaderBoard") { LeaderBoard(navController) }
        //composable("LeaderBoardDetalhes") { LeaderBoardDetalhes(navController) }

        composable("Diario") { DiaryScreen(navController) }

        //composable("More") { MoreScreen(navController) }

        //composable("Treinos") { LoginScreen(navController) }
        //composable("DetalhesTreinos") { LoginScreen(navController) }
        //composable("AdicionarTreino") { LoginScreen(navController) }
        //composable("CriarTreino") { LoginScreen(navController) }

        //composable("Livros") { LoginScreen(navController) }
        //composable("AdicionarLivro") { LoginScreen(navController) }

        //composable("IngestaoAgua") { LoginScreen(navController) }

        //composable("Calorias") { CalorieScreen(navController) }
        composable("AdicionarAlimento") { AdiconarAlimento(navController) }

        //composable("Historico") { FotosScreen(navController) }

        //composable("Definicoes") { DefinicoesScreen(navController) }

        //composable("Notificacoes") { DefinicoesScreen(navController) }

    }
}
