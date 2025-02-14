package co.handler

import co.discord.DiscordClient
import co.discord.DiscordEmbed
import co.discord.DiscordEmbedField
import co.discord.DiscordMessage
import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import kotlinx.coroutines.runBlocking

class SentryDiscordWebhookHandler(
    private val discordClient: DiscordClient = DiscordClient()
) : RequestHandler<Any, APIGatewayProxyResponseEvent> {

    override fun handleRequest(input: Any, context: Context): APIGatewayProxyResponseEvent {
        val event = parseEvent(input)
        val fields = mutableListOf<DiscordEmbedField>().apply {
            listOf("environment", "level", "type", "location", "issue_id").forEach { element ->
                if (event[element] != null) {
                    add(DiscordEmbedField(element, event[element] as String))
                }
            }
        }

        val message = DiscordMessage.of(
            DiscordEmbed.error(
                event["title"] as String,
                event["message"] as String,
                event["web_url"] as String,
                fields
            )
        )

        return runBlocking { discordClient.send(message) }
            .let {
                APIGatewayProxyResponseEvent()
                    .withStatusCode(200)
                    .withBody(jacksonObjectMapper().writeValueAsString(it))
            }
    }

    private fun parseEvent(input: Any): Map<*, *> {
        val request = input as Map<*, *>
        val data = when (request["body"] == null) {
            true -> request["data"] as Map<*, *>
            false -> (request["body"] as Map<*, *>)["data"] as Map<*, *>
        }
        return data["event"] as Map<*, *>
    }
}
