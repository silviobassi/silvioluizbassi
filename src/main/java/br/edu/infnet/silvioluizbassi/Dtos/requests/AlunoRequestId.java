package br.edu.infnet.silvioluizbassi.Dtos.requests;

import io.swagger.v3.oas.annotations.media.Schema;

public record AlunoRequestId(
        @Schema(example = "1")
        Integer id
) {
}
