package br.edu.infnet.silvioluizbassi.Dtos.responses;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public record EspecializacaoResponse(
        @Schema(example = "1")
        Integer id,
        @Schema(example = "Especialização de Java")
        String titulo,
        @Schema(example = "1000.00")
        float valor,
        @Schema(example = "100")
        int cargaHoraria,
        @Schema(example = "Conhecimento básico em Java")
        String preRequisitos,
        @Schema(example = "true")
        boolean estagioObrigatorio,
        @Schema(example = "true")
        boolean ativo,
        @Schema(example = "POS_GRADUACAO")
        String tipoDeEspecializacao,
        List<InstrutorCursoResponse> instrutores
) {
}




