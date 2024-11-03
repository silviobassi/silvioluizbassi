package br.edu.infnet.silvioluizbassi.Dtos.assemblers;

import br.edu.infnet.silvioluizbassi.Dtos.responses.AlunoMatriculaResponse;
import br.edu.infnet.silvioluizbassi.model.domain.Aluno;

public class MontadorAlunoResponse {

    public static AlunoMatriculaResponse toAlunoMatriculaResponse(Aluno aluno) {
        return new AlunoMatriculaResponse(aluno.getId(), aluno.getNome(), aluno.isBolsista(), aluno.isEnem());
    }
}
