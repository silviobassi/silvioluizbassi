package br.edu.infnet.silvioluizbassi.Dtos.requests;

import io.swagger.v3.oas.annotations.media.Schema;

public record UpdateMatriculaRequest(
        @Schema(example = "1")
        Integer id,
        @Schema(example = "2584965")
        Integer numeroDaMatricula,

        AlunoRequestId aluno,
        CursoRequestId curso
) {
}
