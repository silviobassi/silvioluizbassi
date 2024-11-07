package br.edu.infnet.silvioluizbassi.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class ModelBusinessException extends RuntimeException {

    private final String title;
    private final HttpStatus statusCode;

    public ModelBusinessException(String message, String title, HttpStatus statusCode) {
        super(message);
        this.title = title;
        this.statusCode = statusCode;
    }

    public String getTypeError() {
        return title;
    }

}