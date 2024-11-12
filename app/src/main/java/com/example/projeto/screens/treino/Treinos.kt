package com.example.projeto.screens.treino

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.example.projeto.reuse.Header

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Treinos(navController: NavHostController) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    val titleFontSize = (screenWidth.value * 0.06).sp
    val subtitleFontSize = (screenWidth.value * 0.04).sp
    val contentFontSize = (screenWidth.value * 0.03).sp
    val bigIconSize = (screenWidth.value * 0.06).dp
    val smallIconSize = (screenWidth.value * 0.05).dp
    Scaffold(
        topBar = {
            Header(navController)
        },
        content = {
            Column(modifier = Modifier.padding(10.dp, 80.dp)) {
                Row (verticalAlignment = Alignment.CenterVertically){
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier
                            .size(bigIconSize)
                            .clickable {
                                navController.popBackStack()
                            },
                        tint = colorResource(id = R.color.black)
                    )
                    Text(
                        text = stringResource(id = R.string.Treinos),
                        fontSize = titleFontSize,
                        fontWeight = FontWeight.Bold,
                    )
                }


                Text(
                    text = "Hoje ja treinou 1 vez! Falta 1",
                    Modifier.padding(top = 20.dp),
                    fontSize = subtitleFontSize,
                    fontWeight = FontWeight.Bold,
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = stringResource(id = R.string.TreinosHoje),
                    fontSize = subtitleFontSize,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.height(25.dp))

                Column(Modifier.fillMaxSize()) {
                    Column(Modifier.weight(1f)) {
                        Row(modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically){
                            Text(
                                text = stringResource(id = R.string.Indoor),
                                fontSize = subtitleFontSize,
                                fontWeight = FontWeight.Bold,
                                color = colorResource(id = R.color.LaranjaGeral),
                                modifier = Modifier.weight(1f)
                            )
                            Icon(
                                Icons.Filled.AddCircle,
                                contentDescription = "Profile",
                                modifier = Modifier
                                    .size(smallIconSize)
                                    .clickable {
                                        navController.navigate("AdicionarTreino")
                                    },
                                tint = colorResource(id = R.color.LaranjaGeral),
                            )
                        }

                        Column(
                            Modifier
                                .fillMaxSize()
                                .verticalScroll(rememberScrollState())) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height((screenHeight.value * 0.08).dp)
                                    .background(
                                        colorResource(id = R.color.CinzaClaro),
                                        RoundedCornerShape(8.dp)
                                    )
                                    .padding(8.dp, 4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Text(
                                        text = "Corrida 45 minutos",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = contentFontSize,
                                        color = colorResource(id = R.color.black)
                                    )
                                }

                                Icon(
                                    imageVector = Icons.Filled.MoreVert,
                                    contentDescription = "Ver detalhes",
                                    tint = colorResource(id = R.color.LaranjaGeral),
                                    modifier = Modifier
                                        .size(smallIconSize)
                                        .clickable {
                                            navController.navigate("DetalhesTreinos")
                                        }
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                    }

                    Column(Modifier.weight(1f)) {
                        Row(modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically){
                            Text(
                                text = stringResource(id = R.string.Outdoor),
                                fontSize = subtitleFontSize,
                                fontWeight = FontWeight.Bold,
                                color = colorResource(id = R.color.LaranjaGeral),
                                modifier = Modifier.weight(1f)
                            )
                            Icon(
                                Icons.Filled.AddCircle,
                                contentDescription = "Profile",
                                modifier = Modifier
                                    .size(smallIconSize)
                                    .clickable {
                                        navController.navigate("AdicionarLivro")
                                    },
                                tint = colorResource(id = R.color.LaranjaGeral),
                            )
                        }
                        Spacer(modifier = Modifier.height(15.dp))
                        Column(
                            Modifier
                                .fillMaxSize()
                                .verticalScroll(rememberScrollState())) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height((screenHeight.value * 0.08).dp)
                                    .background(
                                        colorResource(id = R.color.CinzaClaro),
                                        RoundedCornerShape(8.dp)
                                    )
                                    .padding(8.dp, 4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(
                                    modifier = Modifier.weight(1f)
                                ) {
                                }
                            }
                            Spacer(Modifier.height(10.dp))
                        }
                    }
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
fun TreinosPreview() {
    val navController = rememberNavController()
    Treinos(navController = navController)
}
