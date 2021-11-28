package com.n0noob.quoteservice.models;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Quote {

    private Long id;

    @NotNull
    @Size(min = 8, message = "quoteText length should be minimum 8 characters")
    private String quoteText;

    @NotNull
    private Long authorId;

}
