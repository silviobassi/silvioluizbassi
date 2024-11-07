package br.edu.infnet.silvioluizbassi.Dtos.responses;

import java.util.List;

public record CursoResponse(
    Integer id,
    String titulo,
    float valor,
    int cargaHoraria,
    String preRequisitos,
    boolean estagioObrigatorio,
    boolean ativo,
    List<InstrutorCursoResponse> instrutores
) {}