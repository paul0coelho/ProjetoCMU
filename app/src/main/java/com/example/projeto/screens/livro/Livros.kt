package com.example.projeto.screens.livro

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import com.example.projeto.reuse.Header

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Livros(paginasLidas : Int, nomes: List<String>, paginas: List<Int>, modifier: Modifier = Modifier, navController: NavHostController) {
    val leaderboardData = nomes.zip(paginas)
    val paginasEmFalta = 10 - paginasLidas

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
                        text = stringResource(id = R.string.PaginasLidas),
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))


                Text(
                    //Nao sei se isto esta a funcionar assim
                    text = stringResource(id = R.string.DescricaoLivros, paginasLidas, paginasEmFalta),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )

                Spacer(modifier = Modifier.height(30.dp))

                Row(modifier = Modifier
                    .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically){
                    Text(
                        text = stringResource(id = R.string.OsSeusLivros),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f)
                    )

                    Icon(
                        Icons.Filled.AddCircle,
                        contentDescription = "Profile",
                        modifier = Modifier.size(24.dp).clickable {
                            navController.navigate("AdicionarLivro")
                        },
                        tint = colorResource(id = R.color.LaranjaGeral),
                    )
                }


                Column {
                    leaderboardData.forEach { (name, pages) ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp)
                                .background(colorResource(id = R.color.CinzaClaro), RoundedCornerShape(8.dp))
                                .padding(8.dp, 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(
                                modifier = Modifier.weight(1f)
                            ) {
                                Text(
                                    text = name,
                                    fontWeight = FontWeight.Bold,
                                    color = colorResource(id = R.color.black)
                                )
                                Text(
                                    text = stringResource(id = R.string.AdicionarPaginas),
                                    color = colorResource(id = R.color.LaranjaGeral),
                                    fontSize = 14.sp,
                                    modifier = Modifier.clickable {}
                                )
                            }

                            Text(
                                text = "$pages",
                                color = colorResource(id = R.color.LaranjaGeral),
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                }

            }
        },
        bottomBar = {
            BottomNavigationBar(navController, "Diario")
        }
    )
}

@Preview(showBackground = true)
@Composable
fun LivrosPreview() {
    val navController = rememberNavController()
    Livros(3,listOf("A Arte de ter sempre razão","Efeito 1%"), listOf(16, 40), navController = navController)
}
