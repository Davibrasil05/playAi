package io.github.davibrasil05.playai.data.remote

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor(private val apiKey: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url = request.url.newBuilder().addQueryParameter("key", apiKey).build()

        return chain.proceed(request.newBuilder().url(url).build())
    }
}