package com.example.kmmfirstapp

import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Runnable
import platform.darwin.dispatch_async
import platform.darwin.dispatch_get_main_queue
import platform.darwin.dispatch_queue_t
import kotlin.coroutines.CoroutineContext

actual class GithubApiClient actual constructor() {

    actual val client: HttpClient = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer(json = kotlinx.serialization.json.Json {
                isLenient = false
                ignoreUnknownKeys = true
                allowSpecialFloatingPointValues = true
                useArrayPolymorphism = false
            })
        }
    }

    actual  val dispatcher: CoroutineDispatcher = Dispatcher(dispatch_get_main_queue())
}

/// iOSの場合はそのままではコルーチンが使えないので以下のようにdispatch_queueを使って対応します。
class Dispatcher(private val dispatchQueue: dispatch_queue_t) : CoroutineDispatcher() {
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        dispatch_async(dispatchQueue) {
            block.run()
        }
    }
}