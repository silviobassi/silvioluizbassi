package br.edu.infnet.silvioluizbassi.exceptions;

import org.springframework.http.HttpStatus;

public class CursoNotFoundException extends ModelBusinessException {

    public CursoNotFoundException() {
        super("Curso não encontrado", CursoNotFoundException.class.getSimpleName(), HttpStatus.NOT_FOUND);
    }

    public CursoNotFoundException(Integer id) {
        super("Curso com %d não encontrado".formatted(id), CursoNotFoundException.class.getSimpleName(),
                HttpStatus.NOT_FOUND);
    }

}
