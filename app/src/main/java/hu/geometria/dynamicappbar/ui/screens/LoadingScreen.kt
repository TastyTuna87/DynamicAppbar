package hu.geometria.dynamicappbar.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 *  [CircularProgressIndicator] loading screen-nek
 *  @param kapcsolodasString: String - képernyő üzenet várakozás közben
 *  @param sikertelen: String - nem sikerült elérni a szervert
 *  @param isConnecting: Boolean - csatlakozás boolean
 *  */
@Composable
fun LoadingScreen(
    kapcsolodasString: String ="Kapcsolodás a szerverhez",
    sikertelen: String = "Sikertelen csatlakozás",
    isConnecting: Boolean
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center
    ) {

        CircularProgressIndicator(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(75.dp)
        )
        Spacer(modifier = Modifier.padding(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            ServerMessage(value = if (kapcsolodasString.isNotEmpty() && isConnecting) kapcsolodasString else sikertelen)
        }
    }
}

@Composable
fun ServerMessage(value: String) {
    Text(
        text = value, modifier = Modifier,
        color = MaterialTheme.colorScheme.onBackground
    )
}