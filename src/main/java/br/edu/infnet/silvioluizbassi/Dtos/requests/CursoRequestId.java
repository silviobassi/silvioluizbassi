package br.edu.infnet.silvioluizbassi.Dtos.requests;

import io.swagger.v3.oas.annotations.media.Schema;

public record CursoRequestId(
        @Schema(example = "2")
        Integer id
) {
}
