package org.example.project.ui.components

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
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import org.example.project.screens.mainScreens.ui.Screen
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun AppScreen(navController: NavHostController, content: @Composable () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        BoxWithConstraints(
            modifier = Modifier.weight(1f)
        ) {
            content()
        }
        navigationBar(navController)
    }
}


@Composable
fun navigationBar(navController: NavHostController) {
    BoxWithConstraints {
        val screenHeight = maxHeight
        val spacing = maxWidth
        Row(
            modifier = Modifier.fillMaxWidth().height(screenHeight * 0.1f).background(Color.Black)
                .padding(horizontal = spacing * 0.1f),
            horizontalArrangement = Arrangement.SpaceAround,
        ) {
            Button(onClick = { navController.navigate(Screen.Home.route) }) {
                Text("Home")
            }
            Button(onClick = { navController.navigate(Screen.TW.route) }) {
                Text("TW")
            }
            Button(onClick = { navController.navigate(Screen.TB.route) }) {
                Text("TB")
            }
            Button(onClick = { navController.navigate(Screen.Settings.route) }) {
                Text("Settings")
            }
        }

    }
}