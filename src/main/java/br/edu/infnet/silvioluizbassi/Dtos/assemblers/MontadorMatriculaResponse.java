package br.edu.infnet.silvioluizbassi.Dtos.assemblers;

import br.edu.infnet.silvioluizbassi.Dtos.responses.MatriculaResponse;
import br.edu.infnet.silvioluizbassi.model.domain.Matricula;

import java.util.List;

public class MontadorMatriculaResponse {

    public static MatriculaResponse toMatriculaResponse(Matricula matricula) {

        return new MatriculaResponse(
                matricula.getId(),
                matricula.getNumeroDaMatricula(),
                matricula.getDataMatricula(),
                matricula.isAtiva(),
                MontadorAlunoResponse.toAlunoMatriculaResponse(matricula.getAluno()),
                MontadorCursoResponse.toCursoMatriculaResponse(matricula.getCurso()),
                MontadorInstrutorResponse.toInstrutoresMatriculaResponse(matricula.getCurso().getInstrutores())
        );
    }

    public static List<MatriculaResponse> toMatriculasResponse(List<Matricula> matriculas) {
        return matriculas.stream().map(MontadorMatriculaResponse::toMatriculaResponse).toList();
    }
}
