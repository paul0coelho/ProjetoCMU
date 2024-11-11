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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
                        text = stringResource(id = R.string.IngestaoAgua),
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .background(colorResource(id = R.color.Cinza), RoundedCornerShape(10.dp)), contentAlignment = Alignment.Center
                    ){
                    Row(Modifier.fillMaxSize(),horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.CenterVertically) {
                        Column(Modifier.weight(1f)) {
                            Text("3L", Modifier.fillMaxWidth(),fontWeight = FontWeight.Bold, fontSize = 20.sp, textAlign = TextAlign.Center)
                            Text(stringResource(id = R.string.Meta),Modifier.fillMaxWidth(),fontWeight = FontWeight.Bold, fontSize = 20.sp, textAlign = TextAlign.Center)
                        }
                        Column(Modifier.weight(1f)) {
                            Text("1,5L",Modifier.fillMaxWidth(), fontWeight = FontWeight.Bold, fontSize = 20.sp, textAlign = TextAlign.Center)
                            Text(stringResource(id = R.string.Ingeridas),Modifier.fillMaxWidth(),fontWeight = FontWeight.Bold, fontSize = 20.sp, textAlign = TextAlign.Center)
                        }
                        Column(Modifier.weight(1f)) {
                            Text("1,5L",Modifier.fillMaxWidth(), fontWeight = FontWeight.Bold, fontSize = 20.sp, textAlign = TextAlign.Center)
                            Text(stringResource(id = R.string.Restantes),Modifier.fillMaxWidth(),fontWeight = FontWeight.Bold, fontSize = 20.sp, textAlign = TextAlign.Center)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = stringResource(id = R.string.DescricaoAgua),
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.height(10.dp))

                Column {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp)
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
                                    color = colorResource(id = R.color.black)
                                )
                            }

                            Text(
                                text = "1.5L",
                                fontWeight = FontWeight.Bold,
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
