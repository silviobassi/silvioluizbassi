package br.edu.infnet.silvioluizbassi.Dtos.responses;

import java.time.LocalDateTime;
import java.util.List;

public record MatriculaResponse(
        long idMatricula,
        long numeroDaMatricula,
        LocalDateTime dataMatricula,
        boolean ativa,
        AlunoMatriculaResponse aluno,
        CursoMatriculaResponse curso,
        List<InstrutorMatriculaResponse> instrutoresCurso
) {
}