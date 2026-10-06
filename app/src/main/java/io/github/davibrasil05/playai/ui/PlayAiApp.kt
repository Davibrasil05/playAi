package io.github.davibrasil05.playai.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import io.github.davibrasil05.playai.ui.navigation.TopLevelDestination
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import io.github.davibrasil05.playai.ui.catalog.CatalogScreen
import io.github.davibrasil05.playai.ui.discover.DiscoverScreen
import io.github.davibrasil05.playai.ui.profile.ProfileScreen

@Composable
fun PlayAiApp() {
    var currentDestination by rememberSaveable{
        mutableStateOf(TopLevelDestination.DISCOVER)}
    Scaffold(
        bottomBar = {
            PlayAiNavigationBar(
                currentDestination = currentDestination,
                onDestinationSelected = {currentDestination = it}
            )
        }
    ) { innerPadding ->
        val modifier = Modifier.padding(innerPadding)
        when (currentDestination){
            TopLevelDestination.DISCOVER -> DiscoverScreen(modifier)
            TopLevelDestination.CATALOG -> CatalogScreen(modifier)
            TopLevelDestination.PROFILE -> ProfileScreen(modifier)
        }

    }
}

@Composable
private fun PlayAiNavigationBar(
    currentDestination: TopLevelDestination,
    onDestinationSelected: (TopLevelDestination) -> Unit,
) {
    NavigationBar {
        TopLevelDestination.entries.forEach { destination ->
            NavigationBarItem(
                selected = destination == currentDestination,
                onClick = {
                    onDestinationSelected(destination) },
                icon = {
                    Icon(painterResource(destination.iconRes), contentDescription = null)
                },
                label = {
                    Text(stringResource(destination.labelRes))
                }
            )
        }
    }
}