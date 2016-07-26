package net.songpon


import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.routing.HttpRouter
import net.songpon.controller.{PingController, QuoteController}

/**
  *
  */
class QuoteAPIServer extends HttpServer {

  override protected def configureHttp(router: HttpRouter): Unit = {
    router.add[PingController]
    router.add[QuoteController]
  }
}
