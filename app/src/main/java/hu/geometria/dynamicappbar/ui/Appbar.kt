package hu.geometria.dynamicappbar.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import hu.geometria.dynamicappbar.dataclasses.Screen
import hu.geometria.dynamicappbar.ui.buttons.HamburgerMenuButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DynamicTopAppBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val screen = when (currentRoute) {
        Screen.Home.route -> Screen.Home
        Screen.MunkaLista.route -> Screen.MunkaLista
        Screen.Munkalap.route -> Screen.Munkalap
        else -> Screen.Home // Default eset
    }

    TopAppBar(
        title = { Text(screen.title) },
        navigationIcon = {
            if (currentRoute == Screen.Home.route) {
                HamburgerMenuButton(navController = navController)
            } else {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                }
            }
        },
        actions = {
            if (currentRoute != Screen.Home.route) {
                IconButton(onClick = { /* Navigáció */ }) {
                    Icon(imageVector = Icons.Outlined.ThumbUp, contentDescription = "Navigation")
                }
                IconButton(onClick = { navController.navigate(Screen.Map.route) }) {
                    Icon(Icons.Outlined.ThumbUp, contentDescription = "Map")
                }
                IconButton(onClick = { /* Kebab menu megnyitása */ }) {
                    Icon(Icons.Outlined.MoreVert, contentDescription = "More")
                }
            }
        }
    )
}