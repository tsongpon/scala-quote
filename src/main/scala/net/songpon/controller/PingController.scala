package net.songpon.controller

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller

/**
  *
  */
class PingController extends Controller {

  get("/scalaquote/ping") { request : Request =>
    "pong"
  }
}
