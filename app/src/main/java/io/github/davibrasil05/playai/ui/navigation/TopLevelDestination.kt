package io.github.davibrasil05.playai.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.navigation3.runtime.NavKey
import io.github.davibrasil05.playai.R

enum class TopLevelDestination (
    val route: NavKey,
    @DrawableRes val iconRes: Int,
    @StringRes val labelRes: Int,
) {
    DISCOVER(
        DiscoverRoute, R.drawable.ic_discover,
            R.string.destination_discover),
    CATALOG(
        CatalogRoute, R.drawable.ic_catalog,
        R.string.destination_catalog),
    PROFILE(ProfileRoute, R.drawable.ic_profile,
        R.string.destination_profile)
}
