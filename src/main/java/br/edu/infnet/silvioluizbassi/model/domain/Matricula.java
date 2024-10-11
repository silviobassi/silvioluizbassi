package br.edu.infnet.silvioluizbassi.model.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Matricula {
    private long numeroDaMatricula;
    private LocalDateTime dataDaCompra;
    private boolean ativa;
    private Curso curso;
    private Aluno aluno;

    @Override
    public String toString() {
        return String.format(
                "Matricula{numeroDaMatricula=%d, dataDaCompra=%s, ativa=%b, curso=%s, aluno=%s}",
                numeroDaMatricula, dataDaCompra, ativa, curso, aluno
        );
    }
}
