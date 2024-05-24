package hu.geometria.dynamicappbar.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import hu.geometria.dynamicappbar.ui.DynamicTopAppBar

@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter") //Scaffold's paddingValues really wants to be used.
fun MunkaListaScreen(navController: NavController) {
    Scaffold(
        topBar = { DynamicTopAppBar(navController,) }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "MunkaListaScreen")
        }
    }
}