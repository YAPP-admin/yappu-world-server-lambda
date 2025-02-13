package co.discord

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.github.cdimascio.dotenv.Dotenv
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.http.*

class DiscordClient {
    suspend fun send(message: DiscordMessage): DiscordWebhookResponse {
        val dotenv = Dotenv.load()
        val response = HttpClient(CIO).use { client ->
            client.post(dotenv["DISCORD_WEBHOOK"]) {
                contentType(ContentType.Application.Json)
                setBody(jacksonObjectMapper().writeValueAsString(message))
            }
        }

        return DiscordWebhookResponse(
            response.status,
            response.body<String>()
        )
    }
}