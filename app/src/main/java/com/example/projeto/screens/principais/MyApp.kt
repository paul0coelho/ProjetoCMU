//package com.example.projeto.screens.principais
//
//import android.annotation.SuppressLint
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Button
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.material3.TopAppBar
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.example.projeto.MainActivity
//import com.example.projeto.R
//import androidx.compose.ui.tooling.preview.Preview
//
//@OptIn(ExperimentalMaterial3Api::class)
//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//@Composable
//fun MyApp() {
//    val context = LocalContext.current
//    val activity = context as? MainActivity // Garante que o contexto é MainActivity
//
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = { Text(text = stringResource(id = R.string.Bem_Vindo)) }
//            )
//        },
//        content = {
//            Column(modifier = Modifier.padding(16.dp)) {
//                Text(
//                    text = stringResource(id = R.string.Bem_Vindo),
//                    fontSize = 20.sp,
//                    fontWeight = FontWeight.Bold,
//                    modifier = Modifier.padding(bottom = 16.dp)
//                )
//
//                LanguageSelectionButtons(onLanguageSelected = { languageTag ->
//                    activity?.updateLocale(languageTag) // Chama a função para alterar o Locale
//                })
//            }
//        }
//    )
//}
//
//@Composable
//fun LanguageSelectionButtons(onLanguageSelected: (String) -> Unit) {
//    Column {
//        Button(
//            onClick = { onLanguageSelected("en") },
//            modifier = Modifier.padding(8.dp)
//        ) {
//            Text("Inglês")
//        }
//        Button(
//            onClick = { onLanguageSelected("es") },
//            modifier = Modifier.padding(8.dp)
//        ) {
//            Text("Espanhol")
//        }
//    }
//}
//
//
//@Preview(showBackground = true)
//@Composable
//private fun MyAppPreview() {
//    MyApp()
//}
//
