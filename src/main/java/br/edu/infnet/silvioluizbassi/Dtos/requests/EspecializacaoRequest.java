package br.edu.infnet.silvioluizbassi.Dtos.requests;

import br.edu.infnet.silvioluizbassi.model.domain.TipoEspecializacao;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public record EspecializacaoRequest(
        @Schema(example = "Especialização de Java")
        String titulo,
        @Schema(example = "Especialização de Java com Spring Boot")
        String descricao,
        @Schema(example = "1000.00")
        float valor,
        @Schema(example = "100")
        int cargaHoraria,
        @Schema(example = "Conhecimento básico em Java")
        String preRequisitos,
        @Schema(example = "true")
        boolean estagioObrigatorio,
        @Schema(example = "EXTENSAO")
        TipoEspecializacao tipoDeEspecializacao,
        List<InstrutorRequestId> instrutores
) {
}
