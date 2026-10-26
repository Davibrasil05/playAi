package io.github.davibrasil05.playai.data.repository

import io.github.davibrasil05.playai.data.remote.RawgApi
import io.github.davibrasil05.playai.data.remote.dto.toGame
import io.github.davibrasil05.playai.model.Game

interface GameRepository {
    suspend fun getGames(genre: String? = null, platform: String? = null): List<Game>
}

class DefaultGameRepository(
    private val api: RawgApi
): GameRepository {
    override suspend fun getGames(genre: String?, platform: String?): List<Game> =
        api.getGames(genres = genre, platforms = platform).results.map { it.toGame() }
}