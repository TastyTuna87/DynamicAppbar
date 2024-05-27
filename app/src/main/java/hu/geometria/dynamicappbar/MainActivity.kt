package hu.geometria.dynamicappbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import hu.geometria.dynamicappbar.ui.views.AppNavigation
import hu.geometria.dynamicappbar.ui.views.LoadingScreen
import hu.geometria.dynamicappbar.ui.theme.DynamicAppbarTheme
import kotlinx.coroutines.delay


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DynamicAppbarTheme {
                App()
            }
        }
    }
}

@Composable
fun App() {
    var showLoadingScreen by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        delay(5000) // 5 másodperc várakozás
        showLoadingScreen = false
    }


        if (showLoadingScreen) {
            LoadingScreen(isConnecting = true)
        } else {
            AppNavigation()
        }
    }

