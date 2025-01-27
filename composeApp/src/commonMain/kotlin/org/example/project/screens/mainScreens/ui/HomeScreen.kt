package org.example.project.screens.mainScreens.ui

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import guildWarScreen
import org.example.project.screens.tbScreen
import org.example.project.ui.components.AppScreen
import org.jetbrains.compose.ui.tooling.preview.Preview



@Composable
fun homeScreen(navController: NavHostController){
    MaterialTheme {
        AppScreen(navController) {

        }
    }
}

