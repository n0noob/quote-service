package com.n0noob.quoteservice.services;

public interface AuthorService {

    com.n0noob.quoteservice.models.Author getAuthor(Long id);

    Long saveAuthor(com.n0noob.quoteservice.models.Author author);

    Long updateAuthor(com.n0noob.quoteservice.models.Author author);

    boolean deleteAuthor(Long id);

}
