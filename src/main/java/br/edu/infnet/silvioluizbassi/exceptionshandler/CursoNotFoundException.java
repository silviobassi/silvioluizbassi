package br.edu.infnet.silvioluizbassi.exceptionshandler;

import org.springframework.http.HttpStatus;

public class CursoNotFoundException extends ModelNotFoundException {

    public CursoNotFoundException() {
        super("Curso não encontrado", CursoNotFoundException.class.getSimpleName());
    }

    public CursoNotFoundException(Integer id) {
        super("Curso com %d não encontrado".formatted(id), CursoNotFoundException.class.getSimpleName());
    }

}