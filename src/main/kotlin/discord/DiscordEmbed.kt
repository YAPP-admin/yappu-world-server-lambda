package co.discord

import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

/**
 * discord embed - https://discord.com/developers/docs/resources/message#embed-object
 * discord color - https://gist.github.com/thomasbnt/b6f455e2c7d743b796917fa3c205f812
 */
data class DiscordEmbed(
    val title: String? = null,
    val type: String = "rich",
    val description: String? = null,
    val url: String? = null,
    val timestamp: String = ZonedDateTime.now(ZoneId.of("Asia/Seoul")).format(DateTimeFormatter.ISO_OFFSET_DATE_TIME),
    val color: Int? = null,
    val fields: List<DiscordEmbedField>? = null
) {
    companion object {

        fun info(
            title: String? = null,
            description: String? = null,
            url: String? = null,
            fields: List<DiscordEmbedField>? = null
        ): DiscordEmbed {
            return DiscordEmbed(
                title = title,
                description = description,
                url = url,
                color = 1752220,
                fields = fields
            )
        }

        fun warn(
            title: String? = null,
            description: String? = null,
            url: String? = null,
            fields: List<DiscordEmbedField>? = null
        ): DiscordEmbed {
            return DiscordEmbed(
                title = title,
                description = description,
                url = url,
                color = 11027200,
                fields = fields
            )
        }

        fun error(
            title: String? = null,
            description: String? = null,
            url: String? = null,
            fields: List<DiscordEmbedField>? = null
        ): DiscordEmbed {
            return DiscordEmbed(
                title = title,
                description = description,
                url = url,
                color = 15548997,
                fields = fields
            )
        }
    }
}

data class DiscordEmbedField(
    val name: String,
    val value: String? = "NULL",
    val inline: Boolean = true
)
