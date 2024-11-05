package br.edu.infnet.silvioluizbassi.Dtos.responses;

import java.util.List;

public record EspecializacaoResponse(
        Integer id,
        String titulo,
        float valor,
        int cargaHoraria,
        String preRequisitos,
        boolean estagioObrigatorio,
        boolean ativo,
        String tipoDeEspecializacao,
        List<InstrutorCursoResponse> instrutores
        ) {
}




