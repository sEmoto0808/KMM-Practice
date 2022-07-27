package com.example.kmmfirstapp

import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Repository(
    val name: String,
    @SerialName("html_url") val url: String,
)

class GithubApi {

    companion object {
        const val BASE_URL = "https://api.github.com"
    }

    private val apiClient = ApiClient()

    @OptIn(DelicateCoroutinesApi::class)
    suspend fun fetchRepos(): List<Repository> {
        val result = apiClient.client.get("$BASE_URL/users/sEmoto0808/repos")
        return result.body()
    }
}