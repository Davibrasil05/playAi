package io.github.davibrasil05.playai.ui.catalog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import io.github.davibrasil05.playai.data.repository.GameRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException

class CatalogViewModel (
    private val repository: GameRepository
) : ViewModel() {
   private val _uiState = MutableStateFlow<CatalogUiState>(CatalogUiState.Loading)
    val uiState: StateFlow<CatalogUiState> = _uiState.asStateFlow()

    init{
        loadGames()
    }

    fun loadGames() {
        _uiState.value = CatalogUiState.Loading
        viewModelScope.launch {
            _uiState.value = try {
                CatalogUiState.Sucess(repository.getGames())
            } catch (e: IOException){
                CatalogUiState.Error
            } catch (e: HttpException){
                CatalogUiState.Error
            }
        }
    }

}