package br.edu.infnet.silvioluizbassi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AlunoNotFoundException extends ModelBusinessException {

    public AlunoNotFoundException() {
        super("Aluno não encontrado", AlunoNotFoundException.class.getSimpleName(), HttpStatus.NOT_FOUND);
    }

    public AlunoNotFoundException(Integer id) {
        super("Aluno com %d não encontrado".formatted(id), AlunoNotFoundException.class.getSimpleName(),
                HttpStatus.NOT_FOUND);
    }

}