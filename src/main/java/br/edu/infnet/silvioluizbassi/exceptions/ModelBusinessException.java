package br.edu.infnet.silvioluizbassi.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public abstract class ModelBusinessException extends RuntimeException {

    protected String errorType;

    @Getter
    private final HttpStatus statusCode;

    public ModelBusinessException(String message, String errorType, HttpStatus statusCode) {
        super(message);
        this.errorType = errorType;
        this.statusCode = statusCode;
    }

    public String getTypeError() {
        return errorType;
    }

}
