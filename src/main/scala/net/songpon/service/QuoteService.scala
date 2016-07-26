package net.songpon.service

import net.songpon.domain.Quote

/**
  *
  */
trait QuoteService {
  def getQuote(id : Int) : Quote
  def getQuotes() : List[Quote]
  def saveQuote(quote : Quote) : Quote
  def deleteQuote(quote : Quote) :  Unit
}
