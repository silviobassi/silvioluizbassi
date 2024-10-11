package br.edu.infnet.silvioluizbassi.model.domain;

public class Aluno extends Pessoa {
    @Override
    public String toString() {
        return String.format("Aluno{nome='%s', dataNascimento=%s, genero=%s}", getNome(), getDataNascimento(), getGenero());
    }
}

