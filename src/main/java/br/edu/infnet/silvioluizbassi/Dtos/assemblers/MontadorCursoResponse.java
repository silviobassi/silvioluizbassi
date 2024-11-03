package br.edu.infnet.silvioluizbassi.Dtos.assemblers;

import br.edu.infnet.silvioluizbassi.Dtos.responses.CursoMatriculaResponse;
import br.edu.infnet.silvioluizbassi.model.domain.Curso;

public class MontadorCursoResponse {

    public static CursoMatriculaResponse toCursoMatriculaResponse(Curso curso) {
        return new CursoMatriculaResponse(curso.getId(), curso.getTitulo(), curso.getDescricao());
    }
}
