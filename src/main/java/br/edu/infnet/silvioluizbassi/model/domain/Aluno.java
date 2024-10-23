package br.edu.infnet.silvioluizbassi.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "taluno")
public class Aluno extends Pessoa {

    private boolean isBolsista;

    @Override
    public String toString() {
        return String.format("Aluno{nome='%s', dataNascimento=%s, genero=%s}", getNome(), getDataNascimento(), getGenero());
    }
}

