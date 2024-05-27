package hu.geometria.dynamicappbar.ui.views

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import hu.geometria.dynamicappbar.dataclasses.NavItem


@Composable
fun AppNavigation() {
    val navController: NavHostController = rememberNavController()
    NavHost(navController = navController, startDestination = NavItem.HomeView.route) {
        composable(NavItem.HomeView.route) { HomeView(navController) }
        composable(NavItem.MunkaListaView.route) { MunkaListaView(navController) }
        composable(NavItem.MunkalapView.route) { MunkalapView(navController) }
        composable(NavItem.TestView.route) { TestView(navController) }

    }
}