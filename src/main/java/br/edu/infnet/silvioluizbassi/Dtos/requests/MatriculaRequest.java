package br.edu.infnet.silvioluizbassi.Dtos.requests;

import io.swagger.v3.oas.annotations.media.Schema;

public record MatriculaRequest(
        @Schema(example = "2584965")
        long numeroMatricula,

        AlunoRequestId aluno,

        CursoRequestId curso
) {
}
