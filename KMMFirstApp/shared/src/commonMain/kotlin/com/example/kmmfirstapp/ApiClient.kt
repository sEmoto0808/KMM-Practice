package com.example.kmmfirstapp

import io.ktor.client.*

expect class ApiClient() {
    val client: HttpClient
}