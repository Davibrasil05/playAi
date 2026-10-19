package io.github.davibrasil05.playai.data.remote.dto

import io.github.davibrasil05.playai.model.Game

fun GameDto.toGame(): Game = Game(
    id = id,
    name = name,
    coverImageUrl = backgroundImage,
    rating = rating.takeIf { it > 0 }, //RAWG returns 0 when nobody has rated the game
    releaseYear = released?.take(4)?.toIntOrNull(),
    playtimeHours = playtime,
    platforms = platforms.orEmpty().map { it.platform.name },
    genres = genres.orEmpty().map {it.name}
)