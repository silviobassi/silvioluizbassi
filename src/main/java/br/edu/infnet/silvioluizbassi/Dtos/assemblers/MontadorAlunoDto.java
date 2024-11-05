package br.edu.infnet.silvioluizbassi.Dtos.assemblers;

import br.edu.infnet.silvioluizbassi.Dtos.responses.AlunoMatriculaResponse;
import br.edu.infnet.silvioluizbassi.Dtos.responses.AlunoResponse;
import br.edu.infnet.silvioluizbassi.Dtos.responses.InstrutorResponse;
import br.edu.infnet.silvioluizbassi.model.domain.Aluno;

import static br.edu.infnet.silvioluizbassi.Dtos.assemblers.MontadorEnderecoDto.*;

public class MontadorAlunoDto {

    public static AlunoMatriculaResponse toAlunoMatriculaResponse(Aluno aluno) {
        return new AlunoMatriculaResponse(aluno.getId(), aluno.getNome(), aluno.isBolsista(), aluno.isEnem());
    }

    public static AlunoResponse toAlunoResponse(Aluno aluno) {
        return new AlunoResponse(
                aluno.getId(),
                aluno.getNome(),
                aluno.getDataNascimento(),
                aluno.getGenero(),
                aluno.getContato().getEmail(),
                aluno.getContato().getWhatsApp(),
                toEnderecoResponse(aluno.getEndereco()),
                aluno.isBolsista(),
                aluno.isEnem()
        );
    }
}
