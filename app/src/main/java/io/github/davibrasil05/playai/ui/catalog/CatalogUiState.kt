package io.github.davibrasil05.playai.ui.catalog

import io.github.davibrasil05.playai.model.Game

sealed interface CatalogUiState {
    data object Loading: CatalogUiState
    data class Sucess(val games: List<Game>) : CatalogUiState
    data object Error: CatalogUiState

}