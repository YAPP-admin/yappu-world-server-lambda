package co.discord

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.http.*

class DiscordClient {
    suspend fun sendAlertServer(message: DiscordMessage, serverWebhook: String): DiscordWebhookResponse {
        val response = HttpClient(CIO).use { client ->
            client.post(serverWebhook) {
                contentType(ContentType.Application.Json)
                setBody(jacksonObjectMapper().writeValueAsString(message))
            }
        }

        return DiscordWebhookResponse(
            response.status.value,
            response.body<String>()
        )
    }
}