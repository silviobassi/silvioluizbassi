package br.edu.infnet.silvioluizbassi.Dtos.responses;

import br.edu.infnet.silvioluizbassi.model.domain.NivelBootcamp;

import java.util.List;

public record BootcampResponse(
        Integer id,
        String titulo,
        float valor,
        int cargaHoraria,
        String preRequisitos,
        boolean estagioObrigatorio,
        boolean ativo,
        NivelBootcamp nivel,
        List<InstrutorCursoResponse> instrutores
) {
}
