package co.discord

import io.ktor.http.*

data class DiscordWebhookResponse(
    val status: HttpStatusCode,
    val response: String
)
