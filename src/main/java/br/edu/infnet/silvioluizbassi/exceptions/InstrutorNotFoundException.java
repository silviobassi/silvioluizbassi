package br.edu.infnet.silvioluizbassi.exceptions;

import org.springframework.http.HttpStatus;

public class InstrutorNotFoundException extends ModelBusinessException {
    public InstrutorNotFoundException() {
        super("Instrutor não encontrado", InstrutorNotFoundException.class.getSimpleName(), HttpStatus.NOT_FOUND);
    }

    public InstrutorNotFoundException(Integer id) {
        super("Instrutor com o id %d não encontrado".formatted(id), InstrutorNotFoundException.class.getSimpleName(),
                HttpStatus.NOT_FOUND);
    }
}