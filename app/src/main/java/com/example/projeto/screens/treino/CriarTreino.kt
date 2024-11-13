package com.example.projeto.screens.treino

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.projeto.R
import com.example.projeto.reuse.BottomNavigationBar
import com.example.projeto.reuse.CaixaTexto
import com.example.projeto.reuse.Header

@SuppressLint("UnrememberedMutableState", "UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CriarTreinoScreen(navController: NavHostController) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    val titleFontSize = (screenWidth.value * 0.07).sp
    val subtitleFontSize = (screenWidth.value * 0.05).sp
    val contentFontSize = (screenWidth.value * 0.03).sp
    val bigIconSize = (screenWidth.value * 0.07).dp
    val smallIconSize = (screenWidth.value * 0.05).dp
    Scaffold(
        topBar = {
            Header(navController)
        },
        content = {paddingValues->
            Column(Modifier.padding(paddingValues)
                .padding(horizontal = 16.dp, vertical = 8.dp).fillMaxHeight()) {
                Row (verticalAlignment = Alignment.CenterVertically){
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier.size(bigIconSize).clickable {
                            navController.popBackStack()
                        },
                        tint = colorResource(id = R.color.black)
                    )
                    Text(
                        text = stringResource(id = R.string.CriarTreino),
                        fontSize = titleFontSize,
                        fontWeight = FontWeight.Bold,
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))
                Column(Modifier.padding(horizontal = 10.dp).fillMaxHeight(),Arrangement.SpaceEvenly) {
                    var nome by remember { mutableStateOf("") }
                    CaixaTexto(
                        stringResource(id = R.string.Nome),
                        nome,
                        { novoNome -> nome = novoNome }, fontSize = subtitleFontSize, iconSize = smallIconSize
                    )
                    var tipo by remember { mutableStateOf("") }
                    CaixaTexto(
                        stringResource(id = R.string.Tipo),
                        tipo,
                        { novoNome -> tipo = novoNome }, fontSize = subtitleFontSize, iconSize = smallIconSize
                    )
                    var duracao by remember { mutableStateOf("") }
                    CaixaTexto(
                        stringResource(id = R.string.Duracao),
                        duracao,
                        { novoNome -> duracao = novoNome }, fontSize = subtitleFontSize, iconSize = smallIconSize
                    )
                    var inicial by remember { mutableStateOf("") }
                    CaixaTexto(
                        stringResource(id = R.string.LocalInicial),
                        inicial,
                        { novoNome -> inicial = novoNome }, fontSize = subtitleFontSize, iconSize = smallIconSize
                    )
                    var final by remember { mutableStateOf("") }
                    CaixaTexto(
                        stringResource(id = R.string.LocalFinal),
                        final,
                        { novoNome -> final = novoNome },fontSize = subtitleFontSize, iconSize = smallIconSize
                    )
                    var data by remember { mutableStateOf("") }
                    CaixaTexto(
                        stringResource(id = R.string.DataInicio),
                        data,
                        { novoNome -> data = novoNome }, fontSize = subtitleFontSize, iconSize = smallIconSize
                    )
                    var hora by remember { mutableStateOf("") }
                    CaixaTexto(
                        stringResource(id = R.string.HoraInicio),
                        hora,
                        { novoNome -> hora = novoNome }, fontSize = subtitleFontSize, iconSize = smallIconSize
                    )
                }


            }
        },
            bottomBar = {
                BottomNavigationBar(navController, "Diario")
            },
        containerColor = colorResource(id = R.color.white)
    )
}

@Preview(showBackground = true)
@Composable
fun CriarTreinoScreenPreview() {
    val navController = rememberNavController()
    CriarTreinoScreen(navController = navController)
}
