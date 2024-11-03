package br.edu.infnet.silvioluizbassi.Dtos.assemblers;

import br.edu.infnet.silvioluizbassi.Dtos.responses.InstrutorMatriculaResponse;
import br.edu.infnet.silvioluizbassi.model.domain.Instrutor;

import java.util.List;

public class MontadorInstrutorResponse {

    public static InstrutorMatriculaResponse toInstrutorMatriculaResponse(Instrutor instrutor) {
        return new InstrutorMatriculaResponse(instrutor.getId(), instrutor.getNome());
    }

    public static List<InstrutorMatriculaResponse> toInstrutoresMatriculaResponse(List<Instrutor> instrutores) {
        return instrutores.stream()
                .map(instrutor -> new InstrutorMatriculaResponse(
                        instrutor.getId(),
                        instrutor.getNome()
                ))
                .toList();
    }
}
