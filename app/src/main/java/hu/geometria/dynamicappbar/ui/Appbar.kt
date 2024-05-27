package hu.geometria.dynamicappbar.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import hu.geometria.dynamicappbar.MainActivityViewModel
import hu.geometria.dynamicappbar.dataclasses.NavItem
import hu.geometria.dynamicappbar.ui.buttons.HamburgerMenuButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DynamicTopAppBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val navItem = when (currentRoute) {
        NavItem.HomeView.route -> NavItem.HomeView
        NavItem.MunkaListaView.route -> NavItem.MunkaListaView
        NavItem.MunkalapView.route -> NavItem.MunkalapView
        else -> NavItem.HomeView // Default eset
    }

    TopAppBar(
        title = { Text(navItem.title) },
        navigationIcon = {
            if (currentRoute == NavItem.HomeView.route) {
                HamburgerMenuButton(navController = navController)
            } else {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                }
            }
        },
        actions = {
            if (currentRoute != NavItem.HomeView.route) {
                IconButton(onClick = { /* Navigáció */ }) {
                    Icon(imageVector = Icons.Outlined.ThumbUp, contentDescription = "Navigation")
                }
                IconButton(onClick = { navController.navigate(NavItem.MapView.route) }) {
                    Icon(Icons.Outlined.ThumbUp, contentDescription = "Map")
                }
                IconButton(onClick = { /* Kebab menu megnyitása */ }) {
                    Icon(Icons.Outlined.MoreVert, contentDescription = "More")
                }
            }
        }
    )
}