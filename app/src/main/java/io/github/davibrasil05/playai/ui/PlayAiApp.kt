package io.github.davibrasil05.playai.ui

import android.provider.ContactsContract
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
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import io.github.davibrasil05.playai.ui.catalog.CatalogScreen
import io.github.davibrasil05.playai.ui.discover.DiscoverScreen
import io.github.davibrasil05.playai.ui.gamedetail.GameDetailScreen
import io.github.davibrasil05.playai.ui.navigation.CatalogRoute
import io.github.davibrasil05.playai.ui.navigation.DiscoverRoute
import io.github.davibrasil05.playai.ui.navigation.GameDetailRoute
import io.github.davibrasil05.playai.ui.navigation.ProfileRoute
import io.github.davibrasil05.playai.ui.profile.ProfileScreen

@Composable
fun PlayAiApp() {
    var currentDestination by rememberSaveable{
        mutableStateOf(TopLevelDestination.DISCOVER)}

    val backStacks = TopLevelDestination.entries.associateWith { destination ->
        rememberNavBackStack(destination.route)
    }
    val backStack = backStacks.getValue(currentDestination)
    Scaffold(
        bottomBar = {
            PlayAiNavigationBar(
                currentDestination = currentDestination,
                onDestinationSelected = {currentDestination = it}
            )
        }
    ) { innerPadding ->
        NavDisplay(
            backStack = backStack,
            onBack = {backStack.removeLastOrNull()},
            modifier = Modifier.padding(innerPadding),
            entryProvider = entryProvider {
                entry<DiscoverRoute> {DiscoverScreen()}
                entry<ProfileRoute> { ProfileScreen()}
                entry<CatalogRoute> { CatalogScreen(onGameClick = {gameId -> backStack.add(
                    GameDetailRoute(gameId))})}
                entry<GameDetailRoute> { route -> GameDetailScreen(gameId = route.gameId) }
            }
        )

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