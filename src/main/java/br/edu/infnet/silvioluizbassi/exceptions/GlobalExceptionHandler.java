package br.edu.infnet.silvioluizbassi.exceptions;

import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ModelBusinessException.class)
    public ProblemDetail handleModelException(ModelBusinessException e) {
        return new CustomProblemDetail(e.getTitle(), e.getMessage(), e.getStatusCode().value());
    }
}