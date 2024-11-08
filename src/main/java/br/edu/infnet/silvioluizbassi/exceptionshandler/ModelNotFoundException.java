package br.edu.infnet.silvioluizbassi.exceptionshandler;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class ModelNotFoundException extends RuntimeException {

    private final String title;
    private final HttpStatus statusCode;

    public ModelNotFoundException(String message, String title) {
        super(message);
        this.title = title;
        this.statusCode = HttpStatus.NOT_FOUND;
    }

    public String getTypeError() {
        return title;
    }

}