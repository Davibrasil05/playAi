package io.github.davibrasil05.playai.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class GamesResponseDto(
    val count: Int,
    val next: String? = null,
    val results: List<GameDto>
)
@Serializable
data class GameDto(
    val id: Int,
    val name: String,
    @SerialName("background_image") val backgroundImage: String? = null,
    val rating: Double = 0.0,
    val released: String? = null,
    val playtime: Int = 0,
    val platforms: List<PlatformWrapperDto>? = null,
    val genres: List<GenreDto>? = null
)

@Serializable
data class PlatformWrapperDto(
    val platform: PlatformDto
)

@Serializable
data class PlatformDto(
    val id: Int,
    val name: String
)

@Serializable
data class GenreDto(
    val id: Int,
    val name: String
)