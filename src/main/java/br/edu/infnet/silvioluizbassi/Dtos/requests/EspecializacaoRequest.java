package br.edu.infnet.silvioluizbassi.Dtos.requests;

import br.edu.infnet.silvioluizbassi.model.domain.TipoEspecializacao;

import java.util.List;

public record EspecializacaoRequest(
        String titulo,
        String descricao,
        float valor,
        int cargaHoraria,
        String preRequisitos,
        boolean estagioObrigatorio,
        TipoEspecializacao tipoDeEspecializacao,
        List<InstrutorRequestId> instrutores
) {
}
