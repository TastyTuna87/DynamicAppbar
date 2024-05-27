package hu.geometria.dynamicappbar.ui.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import hu.geometria.dynamicappbar.dataclasses.NavItem


@Composable
fun HamburgerMenuButton(
    expanded: Boolean = false,
    navController: NavController
) {

    var isExpanded by remember { mutableStateOf(expanded) }

    Box(

    ) {
        IconButton(onClick = { isExpanded = !isExpanded }) {
            Icon(
                imageVector = Icons.Outlined.Menu,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
        if (isExpanded) {
            DropdownMenu(
                expanded = isExpanded, onDismissRequest = { isExpanded = false },
                modifier = Modifier.background(MaterialTheme.colorScheme.onPrimary)
            ) {
                NavItem.MenuItems.items.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(item.title) },
                        onClick = item.action ?: {
                            navController.navigate(item.route)
                            isExpanded = false
                        }
                    )
                }
            }
        }
    }
}
