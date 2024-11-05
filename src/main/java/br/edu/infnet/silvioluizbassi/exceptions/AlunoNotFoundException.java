package br.edu.infnet.silvioluizbassi.exceptions;

import org.springframework.http.HttpStatus;

public class AlunoNotFoundException extends ModelBusinessException {

    public AlunoNotFoundException() {
        super("Aluno não encontrado", AlunoNotFoundException.class.getSimpleName(), HttpStatus.NOT_FOUND);
    }

    public AlunoNotFoundException(Integer id) {
        super("Aluno com %d não encontrado".formatted(id), AlunoNotFoundException.class.getSimpleName(),
                HttpStatus.NOT_FOUND);
    }

}
