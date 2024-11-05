package br.edu.infnet.silvioluizbassi.Dtos.responses;

import br.edu.infnet.silvioluizbassi.model.domain.Genero;

import java.time.LocalDateTime;

public record AlunoResponse(
        Integer id,
        String nome,
        LocalDateTime dataNascimento,
        Genero genero,
        String email,
        String whatsApp,
        EnderecoResponse endereco,
        boolean isBolsista,
        boolean isEnem
) {
}
