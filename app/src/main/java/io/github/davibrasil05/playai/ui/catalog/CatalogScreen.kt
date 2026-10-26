package io.github.davibrasil05.playai.ui.catalog

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import io.github.davibrasil05.playai.R
import io.github.davibrasil05.playai.data.remote.NetworkModule
import io.github.davibrasil05.playai.data.remote.dto.toGame
import io.github.davibrasil05.playai.data.repository.DefaultGameRepository
import io.github.davibrasil05.playai.model.Game
import androidx.compose.runtime.getValue
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import io.github.davibrasil05.playai.ui.components.GameCard

@Composable
fun CatalogScreen(
    onGameClick: (gameId: Int) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: CatalogViewModel = viewModel {
        CatalogViewModel(DefaultGameRepository(NetworkModule.rawgApi))
    }
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    CatalogContent(
        uiState = uiState,
        onGameClick = onGameClick,
        onRetry = viewModel::loadGames,
        modifier = modifier
    )
}

@Composable
private fun CatalogContent(
    uiState: CatalogUiState,
    onGameClick: (gameId: Int) -> Unit,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier

) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        when (uiState) {
            CatalogUiState.Loading -> CircularProgressIndicator()
            CatalogUiState.Error -> CatalogError(onRetry = onRetry)
            is CatalogUiState.Sucess -> GameList(games = uiState.games, onGameClick = onGameClick)
        }
    }
}

@Composable
private fun CatalogError(onRetry: () -> Unit){
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.catalog_error_message),
            style = MaterialTheme.typography.bodyLarge

        )
        Button(onClick = onRetry) {
            Text(stringResource(R.string.action_retry))
        }
    }
}

@Composable
private fun GameList(
    games: List<Game>,
    onGameClick: (gameId: Int) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 150.dp),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(20.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(games, key = { it.id }) { game ->
            GameCard(game = game, onClick = { onGameClick(game.id) })
        }
    }
}