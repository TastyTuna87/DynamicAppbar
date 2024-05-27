package hu.geometria.dynamicappbar

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import hu.geometria.dynamicappbar.dataclasses.NavItem

class MainActivityViewModel() : ViewModel() {
    fun navigate(navController: NavController) {
        navController.navigate(NavItem.TestView.route)
    }
}