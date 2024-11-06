package com.example.projeto.screens.treino

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.projeto.R
import com.example.projeto.reuse.BottomNavigationBar
import com.example.projeto.reuse.Header
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import android.util.Log
import androidx.compose.ui.res.stringResource

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun EvolucaoFotos(navController: NavHostController) {
    val context = LocalContext.current
    var uri by remember { mutableStateOf<Uri?>(null) }
    var hasImage by remember { mutableStateOf<Boolean>(false) }
    var i by remember { mutableIntStateOf(0) }
    val directory = File(context.filesDir, "camera_images").apply { mkdirs() }
    var imageFiles by remember { mutableStateOf(directory.listFiles { file -> file.isFile && file.extension in listOf("jpg", "jpeg", "png") }?.sortedBy { it.lastModified() }
    )  }

    val cameraPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            Log.d("Permissao", "Permissão de câmera concedida")
        } else {
            Log.d("Permissao", "Permissão de câmera negada")
        }
    }

    val storagePermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            Log.d("Permissao", "Permissão de armazenamento concedida")
        } else {
            Log.d("Permissao", "Permissão de armazenamento negada")
        }
    }

    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture(),
        onResult = { success ->
            hasImage = success
        }
    )

    Scaffold(
        topBar = {
            Header(navController)
        },
        content = { PaddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(PaddingValues),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {

                if (imageFiles.isNullOrEmpty()) {

                    Text(
                        text = stringResource(id = R.string.NenhumaImagem),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color =  colorResource(id = R.color.black),
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                } else {

                    Text(
                        text = stringResource(id = R.string.FotoDia) +" ${imageFiles!![i].name.removeSuffix(".jpg").removeSuffix(".jpeg").removeSuffix(".png")}",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.black),
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Foto anterior",
                        tint = colorResource(id = R.color.black),
                        modifier = Modifier
                            .height(36.dp)
                            .width(36.dp)
                            .clickable {
                                if (i > 0) {
                                    i -= 1
                                }
                            }
                    )

                    Box(
                        modifier = Modifier
                            .height(450.dp)
                            .width(300.dp)
                            .background(colorResource(id = R.color.Cinza), RoundedCornerShape(8.dp)),
                        contentAlignment = Alignment.Center,
                    ) {
                        if (!imageFiles.isNullOrEmpty()) {
                            var imagem = imageFiles!![i]
                            imagem?.let {
                                // Carregar a imagem do arquivo
                                val bitmap = BitmapFactory.decodeFile(it.absolutePath)
                                Image(
                                    bitmap = bitmap.asImageBitmap(),
                                    contentDescription = "Background Image",
                                    contentScale = ContentScale.Crop,  // Ajusta a imagem ao tamanho da Box
                                    modifier = Modifier.matchParentSize() // Faz com que a imagem ocupe toda a Box
                                )
                            }
                        }
                    }

                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "Próxima foto",
                        tint = colorResource(id = R.color.black),
                        modifier = Modifier
                            .height(36.dp)
                            .width(36.dp)
                            .clickable {
                                if (imageFiles != null && i < imageFiles!!.size - 1) {
                                    i += 1
                                }
                            }
                    )
                }

                Button(
                    onClick = {

                        if (ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED &&
                            ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                            cameraPermissionLauncher.launch(Manifest.permission.CAMERA)
                            storagePermissionLauncher.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        }
                            Log.d("crazr", "Com permissão")
                            val timeStamp: String = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(Date())
                            val file = File(directory, "$timeStamp.jpg")
                            uri = FileProvider.getUriForFile(context, "${context.packageName}.provider", file)
                            uri?.let { safeUri ->
                                cameraLauncher.launch(safeUri)
                            }
                            imageFiles = directory.listFiles { file -> file.isFile && file.extension in listOf("jpg", "jpeg", "png") }?.sortedBy { it.lastModified() }

                    },
                    colors = ButtonDefaults.buttonColors(Color.Black),
                    modifier = Modifier
                        .padding(horizontal = 80.dp, vertical = 20.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.CameraAlt,
                        contentDescription = "Abrir Câmera",
                        tint = colorResource(id = R.color.LaranjaGeral),
                        modifier = Modifier.size(36.dp)
                    )
                }



            }
        },
        bottomBar = {
            BottomNavigationBar(navController)
        },
        containerColor = colorResource(id = R.color.white)
    )
}


@Preview(showBackground = true)
@Composable
fun EvolucaoFotosPreview() {
    val navController = rememberNavController()
    EvolucaoFotos(navController = navController)
}






