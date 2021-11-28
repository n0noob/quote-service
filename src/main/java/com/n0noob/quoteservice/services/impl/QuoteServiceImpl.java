package com.n0noob.quoteservice.services.impl;

import com.n0noob.quoteservice.entities.Author;
import com.n0noob.quoteservice.entities.Quote;
import com.n0noob.quoteservice.repositories.AuthorRepository;
import com.n0noob.quoteservice.repositories.QuoteRepository;
import com.n0noob.quoteservice.services.QuoteService;
import com.n0noob.quoteservice.services.mappers.QuoteMapper;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Slf4j
@Service
public class QuoteServiceImpl implements QuoteService {

    @Autowired
    private QuoteRepository quoteRepository;

    @Autowired
    private AuthorRepository authorRepository;

    private QuoteMapper quoteMapper = Mappers.getMapper(QuoteMapper.class);

    @Override
    public com.n0noob.quoteservice.models.Quote getQuote(Long id) {
        return quoteMapper.map(
                quoteRepository.findById(id).orElseThrow()
        );
    }

    @Override
    public Long saveQuote(com.n0noob.quoteservice.models.Quote quote) {
        Quote quoteEntity = quoteMapper.map(quote);

        //Map authorId to author
        Author author = authorRepository.findById(quote.getId()).orElseThrow();
        quoteEntity.setAuthor(author);

        return quoteRepository.save(quoteEntity).getId();
    }

    @Override
    public Long updateQuote(com.n0noob.quoteservice.models.Quote quote) {
        if(!quoteRepository.existsById(quote.getId())) {
           throw new NoSuchElementException("Element not found");
        }

        Quote quoteEntity = quoteMapper.map(quote);

        //Map authorId to author
        Author author = authorRepository.findById(quote.getId()).orElseThrow();
        quoteEntity.setAuthor(author);

        return quoteRepository.save(quoteEntity).getId();
    }

    @Override
    public boolean deleteQuote(Long id) {
        quoteRepository.deleteById(id);
        return true;
    }
}
