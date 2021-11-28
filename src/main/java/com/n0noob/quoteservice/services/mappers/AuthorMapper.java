package com.n0noob.quoteservice.services.mappers;

import com.n0noob.quoteservice.entities.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AuthorMapper {

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Author map(com.n0noob.quoteservice.models.Author author);

    com.n0noob.quoteservice.models.Author map(Author author);

}
