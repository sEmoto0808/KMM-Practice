package com.example.kmmfirstapp

import io.ktor.client.request.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Repository(
    val name: String,
    @SerialName("html_url") val url: String,
)

class GithubApi {

    private val apiClient: GithubApiClient = GithubApiClient()

    companion object {
        const val BASE_URL = "https://api.github.com"
    }

    fun fetchRepos(callback: (List<Repository>) -> Unit) {
        GlobalScope.apply {
            launch(apiClient.dispatcher) {
//                val result = apiClient.client.get<List<Repository>>("$BASE_URL/users/sEmoto0808/repos")
//                callback(result)
            }
        }
    }
}