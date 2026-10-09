package io.github.davibrasil05.playai.ui.gamedetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import io.github.davibrasil05.playai.R

@Composable
fun GameDetailScreen(
    gameId: Int,
    modifier: Modifier = Modifier,
){
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(
            text = stringResource(R.string.game_detail_title, gameId),
            style = MaterialTheme.typography.headlineLarge
        )
    }
}