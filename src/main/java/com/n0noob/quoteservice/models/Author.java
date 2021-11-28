package com.n0noob.quoteservice.models;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Author {

    private Long id;

    @NotNull(message = "fullName is mandatory")
    @Size(min = 2, max = 50, message = "fullName length should be in range 2 to 50 (both inclusive)")
    private String fullName;

    private LocalDateTime dob;

    @Size(min = 4, max = 256, message = "bioLink length should be in range 4 to 256 (both inclusive)")
    private String bioLink;

}
