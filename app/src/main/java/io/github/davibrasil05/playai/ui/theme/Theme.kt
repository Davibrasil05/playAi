package io.github.davibrasil05.playai.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = CatalinaBlue,
    onPrimary = SeaSand,
    secondary = CatalinaBlue,
    background = SeaSand,
    onBackground = CatalinaBlue,
    surface = SeaSand,
    onSurface = CatalinaBlue,
    surfaceContainer = Sand,
    secondaryContainer = CatalinaBlue,
    onSecondaryContainer = SeaSand,
    onSurfaceVariant = Slate,
    outline = CatalinaBlue,
    outlineVariant = Dune,
)

@Composable
fun PlayAiTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}
