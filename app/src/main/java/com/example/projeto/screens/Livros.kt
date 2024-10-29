package com.example.projeto.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projeto.reuse.BottomNavigationBar
import com.example.projeto.reuse.Header

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Livros(paginasLidas : Int, nomes: List<String>, paginas: List<Int>, modifier: Modifier = Modifier) {
    val leaderboardData = nomes.zip(paginas)
    val paginasEmFalta = 10 - paginasLidas

    Scaffold(
        topBar = {
            Header()
        },
        content = {
            Column(modifier = Modifier.padding(10.dp, 80.dp)) {
                Text(
                    text = "Páginas Lidas",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Hoje já leu $paginasLidas páginas! Faltam $paginasEmFalta!",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )

                Spacer(modifier = Modifier.height(30.dp))

                Row(modifier = Modifier
                    .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically){
                    Text(
                        text = "Os seus livros:",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f)
                    )

                    Icon(
                        Icons.Filled.AddCircle,
                        contentDescription = "Profile",
                        modifier = Modifier.size(24.dp).clickable {},
                        tint = Color(0xFFFF5722),
                    )
                }


                Column {
                    leaderboardData.forEach { (name, pages) ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp)
                                .background(Color.LightGray, RoundedCornerShape(8.dp))
                                .padding(8.dp, 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(
                                modifier = Modifier.weight(1f)
                            ) {
                                Text(
                                    text = name,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )
                                Text(
                                    text = "Adicionar mais páginas lidas",
                                    color = Color(0xFFFF5722),
                                    fontSize = 14.sp,
                                    modifier = Modifier.clickable {}
                                )
                            }

                            Text(
                                text = "$pages",
                                color = Color(0xFFFF5722),
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
            BottomNavigationBar()
        }
    )
}

@Preview(showBackground = true)
@Composable
fun LivrosPreview() {
    Livros(3,listOf("A Arte de ter sempre razão","Efeito 1%"), listOf(16, 40))
}
