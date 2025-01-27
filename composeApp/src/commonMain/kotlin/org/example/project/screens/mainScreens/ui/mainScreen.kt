package org.example.project.screens.mainScreens.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import guildWarScreen
//import org.example.project.screens.mainScreens.logics.AuthRepository
//import org.example.project.screens.mainScreens.logics.MainViewModel
import org.example.project.screens.tbScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun mainScreen() {
//    val viewModel by lazy {MainViewModel(AuthRepository())}
    val navController: NavHostController = rememberNavController()
    NavHost(navController = navController,
        startDestination = Screen.Home.route) {
        composable(Screen.Home.route) { homeScreen(navController) }
        composable(Screen.Settings.route) { settingsScreen(navController) }
        composable(Screen.TW.route) { guildWarScreen(navController) }
        composable(Screen.TB.route) { tbScreen(navController) }
        composable(Screen.LogIn.route) { logInScreen(navController) }
        composable(Screen.Reg.route) { registrationScreen(navController, /*viewModel*/) }
    }

}



sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Settings : Screen("settings")
    data object TW : Screen("tw")
    data object TB : Screen("tb")
    data object LogIn : Screen("login")
    data object Reg : Screen("reg")
}