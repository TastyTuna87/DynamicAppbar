package hu.geometria.dynamicappbar.ui.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import hu.geometria.dynamicappbar.ui.DynamicTopAppBar

@Composable
fun HomeView(navController: NavController) {
    Scaffold(
        topBar = {
            DynamicTopAppBar(
                navController,
            )
        }
    ) {
        Column(modifier = Modifier.padding(it)) {
            Text(text = "Home Screen")
        }
    }
}

