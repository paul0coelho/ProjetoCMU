package com.example.projeto.screens.alimento

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.projeto.R
import androidx.compose.ui.res.stringResource
import com.example.projeto.reuse.BottomNavigationBar
import com.example.projeto.reuse.CaixaTexto
import com.example.projeto.reuse.Header

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AdiconarAlimento(navController: NavHostController) {
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
                    modifier = Modifier.size(30.dp).clickable {
                        navController.popBackStack()
                    },
                    tint = colorResource(id = R.color.black)
                )
                    Text(
                        text = stringResource(id = R.string.Alimentos),
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }


                Spacer(modifier = Modifier.height(10.dp))
                
                var pesquisa by remember { mutableStateOf("") }
                CaixaTexto(
                    label = stringResource(id = R.string.Pesquisar),
                    value = pesquisa,
                    onValueChange = { pesquisa = it }, fontSize = 1.sp, iconSize = 1.dp
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = stringResource(id = R.string.Historico),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.height(10.dp))

                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .background(colorResource(id = R.color.Cinza), RoundedCornerShape(8.dp))
                            .padding(8.dp, 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = "Bolacha Marinheira",
                                fontWeight = FontWeight.Bold,
                                color = colorResource(id = R.color.black)
                            )
                            Text(
                                text = " 26Cal, 1 bolacha",
                                color = colorResource(id = R.color.DarkGray),
                                fontSize = 14.sp
                            )
                        }

                        Icon(
                            imageVector = Icons.Filled.AddCircle,
                            contentDescription = "Ver detalhes",
                            tint = Color(0xFFFF5722),
                            modifier = Modifier
                                .size(24.dp)
                                .clickable { }
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
fun AdiconarAlimentoPreview() {
    val navController = rememberNavController()
    AdiconarAlimento(navController = navController)
}
