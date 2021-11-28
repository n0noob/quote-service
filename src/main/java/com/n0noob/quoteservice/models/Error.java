package com.n0noob.quoteservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Error {

    private String message;
    private String code;

}
