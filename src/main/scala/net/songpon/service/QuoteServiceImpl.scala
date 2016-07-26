package net.songpon.service
import net.songpon.domain.Quote

/**
  *
  */
class QuoteServiceImpl extends QuoteService {

  override def getQuote(id: Int): Quote = {
    Quote("You know, for search", "Elasticsearch")
  }

  override def saveQuote(quote: Quote): Quote = {
    //TODO : Implement save
    quote
  }

  override def deleteQuote(quote: Quote): Unit = {

  }

  override def getQuotes(): List[Quote] = {
    List(
      Quote("You know, for search", "Elasticsearch"),
      Quote("Happiness is not something you postpone for the future; it is something you design for the present.", "Jim Rohn"),
      Quote("Life's simple, you make choices and you don't look back.", "Han - The Fast and the Furious: Tokyo Drift")
    )
  }
}
