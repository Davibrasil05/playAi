package io.github.davibrasil05.playai.ui.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
data object DiscoverRoute: NavKey

@Serializable
data object CatalogRoute: NavKey

@Serializable
data object ProfileRoute: NavKey

@Serializable
data class GameDetailRoute(val gameId: Int) : NavKey