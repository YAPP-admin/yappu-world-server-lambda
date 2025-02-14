package support.fixture

object SentryDiscordWebhookHandlerFixture {
    val body = mapOf(
        "action" to "triggered",
        "actor" to mapOf(
            "id" to "sentry",
            "name" to "Sentry",
            "type" to "application"
        ),
        "data" to mapOf(
            "event" to mapOf(
                "_ref" to 1,
                "_ref_version" to 2,
                "contexts" to mapOf(
                    "browser" to mapOf(
                        "name" to "Chrome",
                        "type" to "browser",
                        "version" to "75.0.3770"
                    ),
                    "os" to mapOf(
                        "name" to "Mac OS X",
                        "type" to "os",
                        "version" to "10.14.0"
                    )
                ),
                "culprit" to "?(<anonymous>)",
                "datetime" to "2019-08-19T21:06:17.677000Z",
                "dist" to null,
                "event_id" to "e4874d664c3540c1a32eab185f12c5ab",
                "exception" to mapOf(
                    "values" to listOf(
                        mapOf(
                            "mechanism" to mapOf(
                                "data" to mapOf(
                                    "message" to "heck is not defined",
                                    "mode" to "stack",
                                    "name" to "ReferenceError"
                                ),
                                "description" to null,
                                "handled" to false,
                                "help_link" to null,
                                "meta" to null,
                                "synthetic" to null,
                                "type" to "onerror"
                            ),
                            "stacktrace" to mapOf(
                                "frames" to listOf(
                                    mapOf(
                                        "abs_path" to "https://static.jsbin.com/js/prod/runner-4.1.7.min.js",
                                        "colno" to 10866,
                                        "context_line" to "{snip} e(a.old),a.active=b,e(a.target,b),setTimeout(function(){c&&c();for(var b,d=a.target.getElementsByTagName(\"iframe\"),e=d.length,f=0,g=a.active {snip}",
                                        "filename" to "/js/prod/runner-4.1.7.min.js",
                                        "function" to null,
                                        "image_addr" to null,
                                        "in_app" to false,
                                        "lineno" to 1,
                                        "module" to "prod/runner-4.1.7"
                                    )
                                )
                            ),
                            "type" to "ReferenceError",
                            "value" to "heck is not defined"
                        )
                    )
                ),
                "fingerprint" to listOf("{{ default }}"),
                "issue_url" to "https://sentry.io/api/0/issues/1117540176/",
                "issue_id" to "1117540176",
                "level" to "error",
                "location" to "<anonymous>",
                "message" to "",
                "metadata" to mapOf(
                    "filename" to "<anonymous>",
                    "type" to "ReferenceError",
                    "value" to "heck is not defined"
                ),
                "platform" to "javascript",
                "project" to 1,
                "received" to 1566248777.677,
                "release" to null,
                "request" to mapOf(
                    "cookies" to null,
                    "data" to null,
                    "env" to null,
                    "fragment" to null,
                    "headers" to listOf(
                        listOf(
                            "User-Agent",
                            "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36"
                        )
                    ),
                    "method" to null,
                    "query_string" to emptyList<String>(),
                    "url" to "https://null.jsbin.com/runner"
                ),
                "sdk" to mapOf(
                    "integrations" to listOf(
                        "InboundFilters",
                        "FunctionToString",
                        "BrowserApiErrors",
                        "Breadcrumbs",
                        "GlobalHandlers",
                        "LinkedErrors",
                        "HttpContext"
                    ),
                    "name" to "sentry.javascript.browser",
                    "packages" to listOf(
                        mapOf(
                            "name" to "npm:@sentry/browser",
                            "version" to "5.5.0"
                        )
                    ),
                    "version" to "5.5.0"
                ),
                "tags" to listOf(
                    listOf("browser", "Chrome 75.0.3770"),
                    listOf("browser.name", "Chrome"),
                    listOf("handled", "no"),
                    listOf("level", "error"),
                    listOf("mechanism", "onerror"),
                    listOf("os", "Mac OS X 10.14.0"),
                    listOf("os.name", "Mac OS X"),
                    listOf("user", "ip:162.217.75.90"),
                    listOf("url", "https://null.jsbin.com/runner")
                ),
                "time_spent" to null,
                "timestamp" to 1566248777.677,
                "title" to "Test: 테스트로 만든 예외입니다. 신경 쓰지 마세요.",
                "type" to "error",
                "url" to "https://sentry.io/api/0/projects/test-org/front-end/events/e4874d664c3540c1a32eab185f12c5ab/",
                "user" to mapOf(
                    "ip_address" to "162.218.85.90"
                ),
                "version" to "7",
                "web_url" to "https://sentry.io/organizations/test-org/issues/1117540176/events/e4874d664c3540c1a32eab185f12c5ab/"
            )
        ),
        "triggered_rule" to "Very Important Alert Rule!",
        "issue_alert" to mapOf(
            "title" to "Very Important Alert Rule!",
            "settings" to listOf(
                mapOf(
                    "name" to "channel",
                    "value" to "#general"
                )
            )
        ),
        "installation" to mapOf(
            "uuid" to "a8e5d37a-696c-4c54-adb5-b3f28d64c7de"
        )
    )
}
