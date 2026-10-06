package io.github.davibrasil05.playai.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(heightDp = 900)
@Composable
private fun TypographyPreview() {
    PlayAiTheme {
        Surface {
            val t = MaterialTheme.typography
            val styles = listOf(
                "displayMedium" to t.displayMedium,
                "headlineLarge" to t.headlineLarge,
                "headlineMedium" to t.headlineMedium,
                "headlineSmall" to t.headlineSmall,
                "titleMedium" to t.titleMedium,
                "bodyLarge" to t.bodyLarge,
                "bodyMedium" to t.bodyMedium,
                "labelLarge" to t.labelLarge,
                "labelMedium" to t.labelMedium,
                "labelSmall" to t.labelSmall
            )
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                styles.forEach { (name, style) ->
                    Text(text = name, style = style )
                }
                Text(text = "descobrir".uppercase(), style = t.labelSmall)
            }

        }
    }
}
