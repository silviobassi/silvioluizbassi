package br.edu.infnet.silvioluizbassi.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "tmatricula")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private long numeroDaMatricula;
    private LocalDateTime dataDaCompra;
    private boolean ativa;

    @ManyToOne(optional = false)
    private Curso curso;

    @ManyToOne(optional = false)
    private Aluno aluno;

    @Override
    public String toString() {
        return String.format(
                "Matricula{numeroDaMatricula=%d, dataDaCompra=%s, ativa=%b, curso=%s, aluno=%s}",
                numeroDaMatricula, dataDaCompra, ativa, curso, aluno
        );
    }
}
