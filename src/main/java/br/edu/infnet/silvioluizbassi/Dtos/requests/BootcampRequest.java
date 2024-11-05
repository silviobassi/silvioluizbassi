package br.edu.infnet.silvioluizbassi.Dtos.requests;

import br.edu.infnet.silvioluizbassi.model.domain.NivelBootcamp;

import java.util.List;

public record BootcampRequest(
        String titulo,
        String descricao,
        float valor,
        int cargaHoraria,
        String preRequisitos,
        boolean estagioObrigatorio,
        NivelBootcamp nivel,
        List<InstrutorRequestId> instrutores
) {
}
