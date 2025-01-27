package org.example.project.screens.mainScreens.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
//import org.example.project.screens.mainScreens.logics.MainViewModel
//import org.example.project.screens.mainScreens.logics.RegistrationState
import org.example.project.ui.components.AppScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun settingsScreen(navController: NavHostController) {
    AppScreen(navController) {
        BoxWithConstraints(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Row {
                Button(
                    modifier = Modifier
                        .width(200.dp)
                        .height(48.dp),
                    onClick = { navController.navigate("login") }) {
                    Text("log", fontSize = 24.sp)
                }
                Spacer(modifier = Modifier.size(25.dp))
                Button(
                    modifier = Modifier
                        .width(200.dp)
                        .height(48.dp),
                    onClick = { navController.navigate("reg") }) {
                    Text("reg", fontSize = 24.sp)
                }
            }
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

            }
        }
    }
}

@Composable
@Preview
fun logInScreen(navController: NavHostController) {
    AppScreen(navController) {

    }
}

@Composable
@Preview
fun registrationScreen(navController: NavHostController,/* viewModel: MainViewModel*/) {
//    val state by viewModel.registrationState.collectAsState()
//
//    var email by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }
//
//    AppScreen(navController) {
//        Column {
//            when (state) {
//                is RegistrationState.Idle -> Text("Enter your email and password.")
//                is RegistrationState.Loading -> CircularProgressIndicator()
//                is RegistrationState.Success -> Text("Registration successful: ${(state as RegistrationState.Success).uid}")
//                is RegistrationState.Error -> Text("Error: ${(state as RegistrationState.Error).message}")
//            }
//            TextField(
//                value = email,
//                onValueChange = { email = it },
//                label = { Text("Email") }
//            )
//            TextField(
//                value = password,
//                onValueChange = { password = it },
//                label = { Text("Password") },
//                visualTransformation = PasswordVisualTransformation()
//            )
//            Button(onClick = {
//                viewModel.register(email, password)
//            }) {
//                Text("Register")
//            }
//        }
//    }
}