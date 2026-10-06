package io.github.davibrasil05.playai.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import io.github.davibrasil05.playai.R

enum class TopLevelDestination (
    @DrawableRes val iconRes: Int,
    @StringRes val labelRes: Int,
) {
    DISCOVER(R.drawable.ic_discover,
            R.string.destination_discover),
    CATALOG(R.drawable.ic_catalog,
        R.string.destination_catalog),
    PROFILE(R.drawable.ic_profile, R.string.destination_profile)
}
