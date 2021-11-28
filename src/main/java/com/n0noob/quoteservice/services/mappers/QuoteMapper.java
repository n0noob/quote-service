package com.n0noob.quoteservice.services.mappers;

import com.n0noob.quoteservice.entities.Quote;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface QuoteMapper {

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "author", ignore = true)
    Quote map(com.n0noob.quoteservice.models.Quote quote);

    @Mapping(target = "authorId", source = "author.id")
    com.n0noob.quoteservice.models.Quote map(Quote quote);
    
}
