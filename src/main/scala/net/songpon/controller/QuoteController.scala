package net.songpon.controller

import javax.inject.Inject

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller
import net.songpon.service.QuoteServiceImpl

/**
  *
  */
class QuoteController @Inject()(quoteService: QuoteServiceImpl) extends Controller {

  get("/scalaquote/api/v1/quotes") { request : Request =>
    try {
      response.ok.json(quoteService.getQuotes())
    } catch {
      case e: Throwable =>  {
        println(e.getMessage)
      }
    }
  }
}
