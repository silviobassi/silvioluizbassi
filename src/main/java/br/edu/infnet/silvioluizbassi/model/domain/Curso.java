package br.edu.infnet.silvioluizbassi.model.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class Curso {
    private String titulo;
    private String descricao;
    private float valor;
    private int cargaHoraria;
    private String preRequisitos;
    private boolean estagioObrigatorio;
    private boolean ativo;
    private List<Instrutor> instrutores = new ArrayList<>();
}
