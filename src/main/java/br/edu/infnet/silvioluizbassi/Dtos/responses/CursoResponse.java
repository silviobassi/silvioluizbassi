package br.edu.infnet.silvioluizbassi.Dtos.responses;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CursoResponse {
    private Integer id;
    private String titulo;
    private float valor;
    private int cargaHoraria;
    private String preRequisitos;
    private boolean estagioObrigatorio;
    private boolean ativo;
    private List<InstrutorCursoResponse> instrutores;
}
