package com.example.projeto.reuse

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.projeto.R

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun Header(navController: NavHostController) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

    val bigIconSize = (screenWidth.value * 0.08).dp
    TopAppBar(
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = colorResource(id = R.color.white),
            titleContentColor = colorResource(id = R.color.black),
            actionIconContentColor = colorResource(id = R.color.black)

        ),
        title = {},
        navigationIcon = {
            Icon(
                Icons.Default.AccountCircle,
                contentDescription = "Profile",
                modifier = Modifier.size(bigIconSize).clickable {
                    navController.navigate("")
                },
                tint = colorResource(id = R.color.black)
            )
        },
        actions = {
            Icon(
                Icons.Default.Notifications,
                contentDescription = "Notifications",
                modifier = Modifier.size(bigIconSize).clickable {
                    navController.navigate("Notificacoes")
                },
                tint = colorResource(id = R.color.black)
            )
        }
    )
}