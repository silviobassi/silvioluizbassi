package br.edu.infnet.silvioluizbassi.Dtos.requests;

import io.swagger.v3.oas.annotations.media.Schema;

public record UpdatePrecoCursoRequest(
        @Schema(example = "1")
        Integer id,
        @Schema(example = "1000.00")
        float preco
) {
}
