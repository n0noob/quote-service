package com.n0noob.quoteservice.services;

public interface QuoteService {

    com.n0noob.quoteservice.models.Quote getQuote(Long id);

    Long saveQuote(com.n0noob.quoteservice.models.Quote quote);

    Long updateQuote(com.n0noob.quoteservice.models.Quote quote);

    boolean deleteQuote(Long id);

}
