package com.n0noob.quoteservice.services;

import com.n0noob.quoteservice.entities.Author;
import com.n0noob.quoteservice.entities.Quote;
import com.n0noob.quoteservice.repositories.QuoteRepository;
import com.n0noob.quoteservice.services.QuoteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
class QuoteServiceTest {

    @Autowired
    private QuoteService quoteService;

    @MockBean
    private QuoteRepository quoteRepository;

    @BeforeEach
    void setUp() {
        Author authorEntity = Author.builder()
                .fullName("Mahatma Gandhi")
                .dob(LocalDateTime.now())
                .bioLink("https://en.wikipedia.org/wiki/Mahatma_Gandhi")
                .build();

        Quote quoteEntity = Quote.builder()
                .quoteText("An eye for eye only ends up making the whole world blind.")
                .author(authorEntity)
                .build();

        Mockito.when(quoteRepository.findById(15L)).thenReturn(Optional.of(quoteEntity));
    }

    @Test
    void whenQuoteIdPresent_thenQuoteIsReturned() {
        quoteService.getQuote(15L);
    }
}