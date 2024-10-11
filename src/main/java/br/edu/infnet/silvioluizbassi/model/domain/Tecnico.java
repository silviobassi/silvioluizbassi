package br.edu.infnet.silvioluizbassi.model.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tecnico extends Curso{
    private String tipoDeHabilitacao;

    @Override
    public String toString() {
        return String.format("Especializacao{titulo='%s', descricao='%s', valor=%.2f, cargaHoraria=%d, tipoDeHabilitacao='%s'}",
                getTitulo(), getDescricao(), getValor(), getCargaHoraria(), tipoDeHabilitacao);
    }
}
