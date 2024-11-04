package br.edu.infnet.silvioluizbassi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.net.URI;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(ModelException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ProblemDetail handleModelException(ModelException e) {

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
        problemDetail.setTitle(e.getErrorType());
        problemDetail.setType(URI.create("https://infnet.edu.br/exceptions/" + e.getErrorType()));

        return problemDetail;
    }
}
