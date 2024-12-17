package org.example.project.Screens

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun homeScreen() {
    val navController: NavHostController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Home.route){
        composable(Screen.Home.route){}
        composable(Screen.TW.route){}
        composable(Screen.TB.route){}
    }
    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            header()
        }

    }
}

@Composable
fun header() {
    BoxWithConstraints {
        val screenHeight = maxHeight
        val spacing = maxWidth
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(screenHeight * 0.1f)
                .background(Color.Black)
                .padding(horizontal = spacing * 0.1f ),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(onClick = { }){
                Text("TW")
            }
            Button(onClick = { }){
                Text("TB")
            }
            Button(onClick = { }){
                Text("Settings")
            }
        }

    }
}



sealed class Screen(val route: String){
    data object Home: Screen("home")
    data object  TW: Screen("tw")
    data object TB: Screen("tb")
}