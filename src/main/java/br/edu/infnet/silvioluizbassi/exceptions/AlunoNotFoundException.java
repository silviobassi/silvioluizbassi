package br.edu.infnet.silvioluizbassi.exceptions;

public class AlunoNotFoundException extends ModelException {
    public AlunoNotFoundException() {
        super("Aluno não encontrado");
        errorType = "AlunoNotFound";
    }

    @Override
    public String getErrorType() {
        return errorType;
    }
}
