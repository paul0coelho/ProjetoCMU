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
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.projeto.R
import com.example.projeto.reuse.BottomNavigationBar
import com.example.projeto.reuse.Header



@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiaryScreen(navController: NavHostController) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    val titleFontSize = (screenWidth.value * 0.07).sp
    val contentFontSize = (screenWidth.value * 0.05).sp
    Scaffold(
        topBar = { Header(navController) },
        content= { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .background(color = colorResource(id = R.color.white)),
                verticalArrangement = Arrangement.spacedBy(5.dp),
            ) {

                Row(Modifier.weight(0.6f)) {
                    Column(Modifier) {
                    Text(
                        stringResource(id = R.string.FotoDia),
                        Modifier.fillMaxWidth(),
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontSize = titleFontSize
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxSize()
                            .padding(horizontal = 35.dp)
                            .padding(vertical = 10.dp)
                            .clip(RoundedCornerShape(30.dp))
                            .background(color = colorResource(id = R.color.LaranjaGeral))
                            .clickable {
                                // Ação ao clicar
                            },
                        contentAlignment = Alignment.Center
                    ) {}
                }
                }

                Column (Modifier.weight(0.5f).padding(20.dp), verticalArrangement = Arrangement.spacedBy(20.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth().weight(1f).padding(horizontal = 20.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(20.dp),


                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                section(stringResource(id = R.string.Calorias),"500 restantes",navController,"Calorias")

                            }
                            Column(modifier = Modifier.weight(1f)) {
                                section(stringResource(id = R.string.Agua),"1,5/3L",navController,"IngestaoAgua")
                            }
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth().weight(1f).padding(horizontal = 20.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(20.dp)
                        ) {
                            Column(modifier = Modifier.weight(1f)){
                                section(stringResource(id = R.string.PaginasLidas),"3/10",navController,"Livros")
                            }
                            Column(modifier = Modifier.weight(1f)){
                                section(stringResource(id = R.string.Treinos),"0/2",navController,"Treinos")
                            }
                        }
                }
            }
        } ,
        bottomBar = { BottomNavigationBar(navController, "Diario") },
        containerColor = colorResource(id = R.color.white)
    )
}

@Composable
fun section(title:String,content:String,navController: NavHostController,route:String){
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    val titleFontSize = (screenWidth.value * 0.06).sp
    val contentFontSize = (screenWidth.value * 0.04).sp
    Column (Modifier) {
        Box(
            Modifier
                .clip(RoundedCornerShape(30.dp)).fillMaxSize()
                .clickable {
                    navController.navigate(route)
                },
            contentAlignment = Alignment.Center
        ) {
            Column(
                Modifier
                    .background(color = colorResource(id = R.color.CinzaClaro))
                    .fillMaxHeight().padding(horizontal = 10.dp)) {
                Text(modifier = Modifier
                    .fillMaxWidth()
                    .weight(.4f)
                    .padding(top = 15.dp),text = title, fontWeight = FontWeight.Bold, fontSize = contentFontSize, textAlign = TextAlign.Center)
                    Text(
                        text = content,
                        fontWeight = FontWeight.Bold,
                        fontSize = titleFontSize,
                        color = colorResource(id = R.color.LaranjaGeral),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                            .weight(.6f)
                    )
                }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun DiaryScreenPreview() {
    val navController = rememberNavController()

    DiaryScreen(navController = navController)
}