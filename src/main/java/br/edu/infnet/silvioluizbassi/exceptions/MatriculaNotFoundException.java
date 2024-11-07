package br.edu.infnet.silvioluizbassi.exceptions;

import org.springframework.http.HttpStatus;

public class MatriculaNotFoundException extends ModelBusinessException {
    public MatriculaNotFoundException() {
        super("Matricula não encontrada", MatriculaNotFoundException.class.getSimpleName(), HttpStatus.NOT_FOUND);
    }
}
