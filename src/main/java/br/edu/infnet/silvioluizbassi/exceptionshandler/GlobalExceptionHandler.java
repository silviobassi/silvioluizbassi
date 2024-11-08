package br.edu.infnet.silvioluizbassi.exceptionshandler;

import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ModelNotFoundException.class)
    public ProblemDetail handleModelException(ModelNotFoundException e) {
        return new CustomProblemDetail(e.getTitle(), e.getMessage(), e.getStatusCode().value());
    }
}