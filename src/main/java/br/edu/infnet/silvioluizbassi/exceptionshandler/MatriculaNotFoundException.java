package br.edu.infnet.silvioluizbassi.exceptionshandler;

import org.springframework.http.HttpStatus;

public class MatriculaNotFoundException extends ModelNotFoundException {
    public MatriculaNotFoundException() {
        super("Matricula não encontrada", MatriculaNotFoundException.class.getSimpleName());
    }
}
