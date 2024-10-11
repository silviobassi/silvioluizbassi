package br.edu.infnet.silvioluizbassi.model.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class Pessoa {
    private String nome;
    private LocalDateTime dataNascimento;
    private Genero genero;
    private Contato contato;
    private Endereco endereco;

}
