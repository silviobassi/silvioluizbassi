package br.edu.infnet.silvioluizbassi.Dtos.requests;

import io.swagger.v3.oas.annotations.media.Schema;

public record InstrutorRequestId(
        @Schema(example = "1")
        Integer id
) {
}
