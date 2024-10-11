package br.edu.infnet.silvioluizbassi.model.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bootcamp extends Curso {
    private String tipoDeBootcamp;

    @Override
    public String toString() {
        return String.format("Bootcamp{titulo='%s', descricao='%s', valor=%.2f, cargaHoraria=%d, tipoDeBootcamp='%s'}",
                getTitulo(), getDescricao(), getValor(), getCargaHoraria(), tipoDeBootcamp);
    }
}
