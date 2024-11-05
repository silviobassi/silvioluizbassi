package br.edu.infnet.silvioluizbassi.exceptions;

import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(ModelBusinessException.class)
    public ProblemDetail handleModelException(ModelBusinessException e) {
        return new CustomProblemDetail(e.getStatusCode().value(), e.getTypeError(), e.getMessage(), e.getTypeError());
    }
}
