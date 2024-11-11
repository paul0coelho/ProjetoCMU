package com.example.projeto.screens.principais

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessibilityNew
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
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

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Notificacoes(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
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
                            text = stringResource(id = R.string.Notificacoes),
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 80.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .background(colorResource(id = R.color.CinzaClaro), RoundedCornerShape(8.dp))
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Calculate,
                        contentDescription = "Calorias",
                        modifier = Modifier.size(30.dp),
                        tint = colorResource(id = R.color.black)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Text(
                            text = stringResource(id = R.string.AtingiuMetaCalorias),
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.black)
                        )
                        Text(
                            text = stringResource(id = R.string.DescricaoMetaCalorias),
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.Gray)
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .background(colorResource(id = R.color.CinzaClaro), RoundedCornerShape(8.dp))
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.AccessibilityNew,
                        contentDescription = "Calorias",
                        modifier = Modifier.size(30.dp),
                        tint = colorResource(id = R.color.black)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Text(
                            text = stringResource(id = R.string.AtingiuMetaTreino),
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.black)
                        )
                        Text(
                            text = stringResource(id = R.string.DescricaoMetaTreino),
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.Gray)
                        )
                    }
                }
            }
        },
        bottomBar = {
            BottomNavigationBar(navController, "More")
        }
    )
}

@Preview(showBackground = true)
@Composable
fun NotificacoesPreview() {
    val navController = rememberNavController()
    Notificacoes(navController = navController)
}
