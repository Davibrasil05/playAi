package io.github.davibrasil05.playai.model

data class Game(
    val id: Int,
    val name: String,
    val coverImageUrl: String?,
    val rating: Double?,
    val releaseYear: Int?,
    val playtimeHours: Int,
    val platforms: List<String>,
    val genres: List<String>
)
