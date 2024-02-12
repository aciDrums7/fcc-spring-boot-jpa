package com.freecodecamp.springBootJpa.BLL.exceptions;

import static java.lang.StringTemplate.STR;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoSuchElementFoundException extends NoSuchElementException /* extends ResponseStatusException */ {

    public NoSuchElementFoundException() {
        super();
    }

    public NoSuchElementFoundException(String message) {
        super(message);
    }

    public NoSuchElementFoundException(Throwable cause) {
        super(cause);
    }

    public NoSuchElementFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public static <T extends Number> String elementNotFoundById(T id) {
        return STR."Element with ID: \{id} not found";
    }
}
