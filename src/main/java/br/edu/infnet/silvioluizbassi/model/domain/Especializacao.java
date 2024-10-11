package br.edu.infnet.silvioluizbassi.model.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Especializacao extends Curso {
    private String nivelDeEspecializacao;

    @Override
    public String toString() {
        return String.format("Especializacao{titulo='%s', descricao='%s', valor=%.2f, cargaHoraria=%d, nivelDeEspecializacao='%s'}",
                getTitulo(), getDescricao(), getValor(), getCargaHoraria(), nivelDeEspecializacao);
    }
}
