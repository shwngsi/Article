/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aol.obi.article.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Pankaj Patel
 * @version 1.0
 * @since 05/27/2015
 */
@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Bad Request")
public class InvalidRequestException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private final Errors errors;

    public InvalidRequestException(String message) {
        super(message);
        this.errors = null;
    }

    public InvalidRequestException(String message, Errors errors) {
        super(message);
        this.errors = errors;
    }

    public Errors getErrors() {
        return errors;
    }
}
