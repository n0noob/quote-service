package com.n0noob.quoteservice.controllers;

import com.n0noob.quoteservice.models.Author;
import com.n0noob.quoteservice.services.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "Author")
@Slf4j
@RestController
@RequestMapping("rest_best_practices/v1/authors/")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @Operation(summary = "Get author details for a given author id")
    @GetMapping("/{id}")
    public Author getAuthor(/*@ApiParam("Author Id")*/ @PathVariable long id) {
        log.info("Received request for author id : " + id);
        return authorService.getAuthor(id);
    }

    @Operation(summary = "Register a new author")
    @PostMapping("/")
    public Long addAuthor(@Valid @RequestBody Author author) {
        log.info("Received request for adding author : " + author.toString());
        return authorService.saveAuthor(author);
    }

    @Operation(summary = "Update author corresponding to a given author id")
    @PutMapping("/")
    public Long updateAuthor(@Valid @RequestBody Author author) {
        log.info("Received request for updating author with id : " + author.getId());
        return authorService.updateAuthor(author);
    }

    @Operation(summary = "Delete author details for a given author id")
    @DeleteMapping("/{id}")
    public void deleteAuthor(/*@ApiParam("Author Id")*/ @PathVariable long id) {
        log.info("Received request for deleting author with id : " + id);
        authorService.deleteAuthor(id);
    }

}
