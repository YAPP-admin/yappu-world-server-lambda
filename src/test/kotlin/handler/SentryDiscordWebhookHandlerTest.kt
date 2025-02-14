package handler

import co.discord.DiscordClient
import co.handler.SentryDiscordWebhookHandler
import com.amazonaws.services.lambda.runtime.Context
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.mockk.mockk
import org.junit.jupiter.api.Test
import support.fixture.SentryDiscordWebhookHandlerFixture
import kotlin.test.assertTrue

class SentryDiscordWebhookHandlerTest {

    val mockContext = mockk<Context>()

    // 실행 결과는 test-webhook channel을 확인하세요
    @Test
    fun `데이터를 파싱하여 디스코드에 메세지를 보낸다`() {
        val responseEvent = SentryDiscordWebhookHandler(DiscordClient()).handleRequest(
            SentryDiscordWebhookHandlerFixture.body,
            mockContext
        )

        val parsedResponseBody = jacksonObjectMapper().readValue(responseEvent.body, Map::class.java)
        assertTrue { (parsedResponseBody["status"].toString()).startsWith("2") }
    }
}