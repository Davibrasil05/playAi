package io.github.davibrasil05.playai.data.remote

import io.github.davibrasil05.playai.data.remote.dto.GamesResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface RawgApi {
    @GET("games")
    suspend fun getGames(
        @Query("genres") genres: String? = null,
        @Query("platforms") platforms: String? = null,
        @Query("search") search: String? = null,
        @Query("page") page: Int = 1,
        @Query("page_size") pageSize: Int = 20
    ): GamesResponseDto
}