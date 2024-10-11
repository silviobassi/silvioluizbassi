package br.edu.infnet.silvioluizbassi.model.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Instrutor extends Pessoa {
    private String formacao;
    private String especialidade;

    @Override
    public String toString() {
        return String.format("Instrutor{nome='%s', dataNascimento=%s, genero=%s, formacao=%s, especialidade=%s}",
                getNome(), getDataNascimento(), getGenero(), formacao, especialidade);
    }
}
