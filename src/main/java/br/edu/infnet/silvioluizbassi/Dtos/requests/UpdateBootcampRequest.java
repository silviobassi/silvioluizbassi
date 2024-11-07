package br.edu.infnet.silvioluizbassi.Dtos.requests;

import br.edu.infnet.silvioluizbassi.model.domain.NivelBootcamp;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public record UpdateBootcampRequest(
        @Schema(example = "1")
        Integer id,
        @Schema(example = "Bootcamp de Java")
        String titulo,
        @Schema(example = "Bootcamp de Java com Spring Boot")
        String descricao,
        @Schema(example = "1000.00")
        float valor,
        @Schema(example = "100")
        int cargaHoraria,
        @Schema(example = "Conhecimento básico em Java")
        String preRequisitos,
        @Schema(example = "true")
        boolean estagioObrigatorio,
        @Schema(example = "INTERMEDIARIO")
        NivelBootcamp nivel,
        List<InstrutorRequestId> instrutores
) {
}
