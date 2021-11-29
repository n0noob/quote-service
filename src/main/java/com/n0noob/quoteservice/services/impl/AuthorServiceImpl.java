package com.n0noob.quoteservice.services.impl;

import com.n0noob.quoteservice.entities.Author;
import com.n0noob.quoteservice.repositories.AuthorRepository;
import com.n0noob.quoteservice.services.AuthorService;
import com.n0noob.quoteservice.services.mappers.AuthorMapper;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    private AuthorMapper authorMapper = Mappers.getMapper(AuthorMapper.class);

    @Override
    public com.n0noob.quoteservice.models.Author getAuthor(Long id) {
        return authorMapper.map(
                authorRepository.findById(id).orElseThrow()
        );
    }

    @Override
    public Long saveAuthor(com.n0noob.quoteservice.models.Author author) {
        Author authorEntity = authorMapper.map(author);
        return authorRepository.save(authorEntity).getId();
    }

    @Override
    public Long updateAuthor(com.n0noob.quoteservice.models.Author author) {
        Author authorOld =  authorRepository.findAnyByFullName(author.getFullName());

        Author authorEntity = authorMapper.map(author);
        authorEntity.setId(authorOld.getId());
        return authorRepository.save(authorEntity).getId();
    }

    @Override
    public boolean deleteAuthor(Long id) {
        authorRepository.deleteById(id);
        return true;
    }

}
