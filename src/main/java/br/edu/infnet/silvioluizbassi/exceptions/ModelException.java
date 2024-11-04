package br.edu.infnet.silvioluizbassi.exceptions;

public abstract class ModelException extends RuntimeException {

    protected String errorType;

    public ModelException(String message) {
        super(message);
    }

    public abstract String getErrorType();
}
