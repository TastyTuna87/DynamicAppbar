package hu.geometria.dynamicappbar.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import hu.geometria.dynamicappbar.dataclasses.Screen


@Composable
fun AppNavigation() {
    val navController: NavHostController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.MunkaLista.route) { MunkaListaScreen(navController) }
        composable(Screen.Munkalap.route) { MunkalapScreen(navController) }

    }
}