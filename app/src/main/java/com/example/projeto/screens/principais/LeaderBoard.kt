package com.example.projeto.screens.principais

import com.example.projeto.reuse.Header
import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LeaderBoard(dia: Int, nomes: List<String>, dias: List<Int>, modifier: Modifier = Modifier, navController: NavHostController) {
    val leaderboardData = nomes.zip(dias)

    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("Atual") }
    val options = listOf("Atual", "De Sempre")

    Scaffold(
        topBar = {
            Header(navController)
        },
        content = {
            Column(modifier = Modifier.padding(10.dp, 80.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(id = R.string.Board),
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Box {
                        Row(
                            modifier = Modifier
                                .clickable { expanded = true }
                                .padding(4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = selectedOption,
                                fontSize = 18.sp
                            )
                            Icon(
                                imageVector = Icons.Filled.ArrowDropDown,
                                contentDescription = "Abrir menu dropdown",
                                modifier = Modifier.size(24.dp)
                            )
                        }
                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            options.forEach { option ->
                                DropdownMenuItem(
                                    text = { Text(option) },
                                    onClick = {
                                        selectedOption = option
                                        expanded = false
                                    }
                                )
                            }
                        }
                    }
                }

                Column {
                    leaderboardData.forEachIndexed { index, (name, streakDays) ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp)
                                .background(
                                    color = if (name == "Eu") colorResource(id = R.color.LaranjaGeral) else colorResource(id = R.color.CinzaClaro),
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .padding(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "${index + 1}#",
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                color = if (name == "Eu") colorResource(id = R.color.white) else colorResource(id = R.color.black),
                                modifier = Modifier.padding(end = 8.dp)
                            )
                            Text(
                                text = name,
                                fontWeight = FontWeight.Bold,
                                color = if (name == "Eu") colorResource(id = R.color.white) else colorResource(id = R.color.black),
                                modifier = Modifier.weight(1f)
                            )
                            Text(
                                text = stringResource(id = R.string.Dias, streakDays) ,
                                fontWeight = FontWeight.Medium,
                                color = if (name == "Eu") colorResource(id = R.color.white) else colorResource(id = R.color.DarkGray),
                                modifier = Modifier.padding(end = 8.dp)
                            )
                            Icon(
                                imageVector = Icons.Filled.Info,
                                contentDescription = "Ver detalhes",
                                tint = if (name == "Eu") colorResource(id = R.color.white) else colorResource(id = R.color.LaranjaGeral),
                                modifier = Modifier
                                    .size(24.dp)
                                    .clickable { navController.navigate("LeaderBoardDetalhes") }
                            )
                        }
                    }
                }
            }
        },
        bottomBar = {
            BottomNavigationBar(navController, "Desafio")
        }
    )
}

@Preview(showBackground = true)
@Composable
fun LeaderBoardPreview() {
    val navController = rememberNavController()
    LeaderBoard(10, listOf("Andy Frisella", "John Doe", "Paulo Coelho", "Eu"), listOf(1000, 950, 851, 10), navController = navController)
}
