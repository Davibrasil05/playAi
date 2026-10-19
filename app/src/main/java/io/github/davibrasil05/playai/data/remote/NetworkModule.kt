package io.github.davibrasil05.playai.data.remote

import io.github.davibrasil05.playai.BuildConfig
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory


object NetworkModule {

    private const val BASE_URL = "https://api.rawg.io/api/"

    private val json = Json {ignoreUnknownKeys = true}

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG)
            HttpLoggingInterceptor.Level.BASIC else
            HttpLoggingInterceptor.Level.NONE
        redactQueryParams("key")
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(ApiKeyInterceptor(BuildConfig.RAWG_API_KEY))
        .addInterceptor(loggingInterceptor)
        .build()

    val rawgApi: RawgApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()
        .create(RawgApi::class.java)


}