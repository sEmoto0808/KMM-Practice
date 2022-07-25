package com.example.kmmfirstapp

import io.ktor.client.*
import io.ktor.client.engine.darwin.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*

actual class ApiClient actual constructor() {
    actual val client: HttpClient = HttpClient(Darwin) {
        install(ContentNegotiation) {
            json()
        }
    }
}