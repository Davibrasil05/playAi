package io.github.davibrasil05.playai.ui.components

import android.view.RoundedCorner
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import io.github.davibrasil05.playai.R
import io.github.davibrasil05.playai.model.Game
import io.github.davibrasil05.playai.ui.theme.PlayAiTheme

@Composable
fun GameCard(
    game: Game,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceContainer)
    ) {
        val placeholder = ColorPainter(MaterialTheme.colorScheme.outlineVariant)
        AsyncImage(
            model = game.coverImageUrl,
            contentDescription = null,
            placeholder = placeholder,
            error = placeholder,
            fallback = placeholder,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16f / 9f)
        )
        Column(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = game.name,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            GameMeta(rating = game.rating, releaseYear = game.releaseYear)
        }
    }
}

@Composable
private fun GameMeta(rating: Double?, releaseYear: Int?){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        if (rating != null) {
            Icon(
                painter = painterResource(R.drawable.ic_star),
                null,
                modifier = Modifier.size(12.dp)
            )
            Text(
                text = stringResource(R.string.game_rating, rating),
                style = MaterialTheme.typography.labelMedium
            )
        }
        if (rating != null && releaseYear != null) {
            Text(text = "·", color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
        if(releaseYear != null){
            Text(
                text = releaseYear.toString(),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
@Preview
@Composable
private fun GameCardPreview() {
    PlayAiTheme {
        GameCard(
            game = Game(
                id = 1,
                name = "The Witcher 3: Wild Hunt",
                coverImageUrl = null,
                rating = 4.64,
                releaseYear = 2015,
                playtimeHours = 43,
                platforms = listOf("PC"),
                genres = listOf("RPG"),
            ),
            onClick = {},

            )
    }
}