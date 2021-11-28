package com.n0noob.quoteservice.repositories;

import com.n0noob.quoteservice.entities.Author;
import com.n0noob.quoteservice.repositories.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertSame;

@DataJpaTest
class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void givenAuthor_whenAuthorNotPresentInDB_thenAuthorGetsSaved() {
        //when
        String authorName = "Mahatma Gandhi";
        Author author = Author.builder()
                .fullName(authorName)
                .dob(LocalDateTime.now())
                .bioLink("https://en.wikipedia.org/wiki/Mahatma_Gandhi")
                .build();

        Long id = authorRepository.save(author).getId();

        //then
        assertSame(authorRepository.findById(id).orElseThrow().getFullName(), authorName);
    }

}
