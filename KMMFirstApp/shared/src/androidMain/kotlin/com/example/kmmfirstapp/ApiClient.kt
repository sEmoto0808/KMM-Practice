package com.example.kmmfirstapp

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*

actual class ApiClient actual constructor() {
    actual val client: HttpClient = HttpClient(Android) {
        install(ContentNegotiation) {
            json()
        }
    }
}