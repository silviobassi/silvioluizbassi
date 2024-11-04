package br.edu.infnet.silvioluizbassi.exceptions;

public class CursoNotFoundException extends ModelException {
    public CursoNotFoundException() {
        super("Curso não encontrado");
        errorType = "AlunoNotFound";
    }

    @Override
    public String getErrorType() {
        return errorType;
    }
}
