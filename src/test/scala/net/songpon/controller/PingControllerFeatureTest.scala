package net.songpon.controller

import com.twitter.finagle.http.Status
import com.twitter.finatra.http.EmbeddedHttpServer
import com.twitter.inject.server.{EmbeddedTwitterServer, FeatureTest}
import net.songpon.QuoteAPIServer

/**
  *
  */
class PingControllerFeatureTest extends FeatureTest {
  override val server: EmbeddedHttpServer = new EmbeddedHttpServer( twitterServer = new QuoteAPIServer)

  "Tests - ping" in {
    server.httpGet(
      path = "/scalaquote/ping",
      andExpect = Status.Ok,
      withBody = "pong"
    )
  }
}
