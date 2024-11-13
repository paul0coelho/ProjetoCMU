package com.example.projeto.screens.alimento

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.projeto.reuse.BottomNavigationBar
import com.example.projeto.reuse.Header
import com.example.projeto.R
import androidx.compose.ui.res.stringResource

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun IngestaoAgua(navController: NavHostController) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    val titleFontSize = (screenWidth.value * 0.07).sp
    val subtitleFontSize = (screenWidth.value * 0.05).sp
    val contentFontSize = (screenWidth.value * 0.03).sp
    val bigIconSize = (screenWidth.value * 0.07).dp
    val smallIconSize = (screenWidth.value * 0.06).dp
    Scaffold(
        topBar = {
            Header(navController)
        },
        content = {paddingValues->
            Column(modifier = Modifier.padding(paddingValues)
                .padding(horizontal = 16.dp, vertical = 8.dp)) {
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
                        text = stringResource(id = R.string.IngestaoAgua),
                        fontSize = titleFontSize,
                        fontWeight = FontWeight.Bold,
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height((screenHeight.value*0.1).dp)
                        .background(colorResource(id = R.color.Cinza), RoundedCornerShape(10.dp)), contentAlignment = Alignment.Center
                    ){
                    Row(Modifier.fillMaxSize(),horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.CenterVertically) {
                        Column(Modifier.weight(1f)) {
                            Text("3L", Modifier.fillMaxWidth(),fontWeight = FontWeight.Bold, fontSize = subtitleFontSize, textAlign = TextAlign.Center)
                            Text(stringResource(id = R.string.Meta),Modifier.fillMaxWidth(),fontWeight = FontWeight.Bold, fontSize = subtitleFontSize, textAlign = TextAlign.Center)
                        }
                        Column(Modifier.weight(1f)) {
                            Text("1,5L",Modifier.fillMaxWidth(), fontWeight = FontWeight.Bold, fontSize = subtitleFontSize, textAlign = TextAlign.Center)
                            Text(stringResource(id = R.string.Ingeridas),Modifier.fillMaxWidth(),fontWeight = FontWeight.Bold, fontSize = subtitleFontSize, textAlign = TextAlign.Center)
                        }
                        Column(Modifier.weight(1f)) {
                            Text("1,5L",Modifier.fillMaxWidth(), fontWeight = FontWeight.Bold, fontSize = subtitleFontSize, textAlign = TextAlign.Center)
                            Text(stringResource(id = R.string.Restantes),Modifier.fillMaxWidth(),fontWeight = FontWeight.Bold, fontSize = subtitleFontSize, textAlign = TextAlign.Center)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = stringResource(id = R.string.DescricaoAgua),
                    fontSize = subtitleFontSize,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.height(10.dp))

                Column(Modifier.verticalScroll(rememberScrollState())) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth().height((screenHeight.value*0.08).dp)
                                .background(colorResource(id = R.color.CinzaClaro), RoundedCornerShape(8.dp))
                                .padding(30.dp, 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(
                                modifier = Modifier.weight(1f)
                            ) {
                                Text(
                                    text = "20:45",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = subtitleFontSize,
                                    color = colorResource(id = R.color.black)
                                )
                            }

                            Text(
                                text = "1.5L",
                                fontWeight = FontWeight.Bold,
                                fontSize = subtitleFontSize,
                                color = colorResource(id = R.color.LaranjaGeral)
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))

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
fun IngestaoAguaPreview() {
    val navController = rememberNavController()
    IngestaoAgua(navController = navController)
}
